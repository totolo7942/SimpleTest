package com.javabydeveloper.repository.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javabydeveloper.model.User;
import com.javabydeveloper.util.UserType;

@Repository
public class UserJdbcTemplate {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM USER_DETAILS", Integer.class);
	}

	public int save(User user) {
		return jdbcTemplate.update(
				"INSERT INTO `USER_DETAILS` (USER_NAME, PASSWORD, CREATED_TIME, UPDATED_TIME, USER_TYPE, DOB)"
						+ " VALUES(?,?,?,?,?,?)",
				user.getUserName(), user.getPassword(), user.getCreatedTime(), user.getUpdatedTime(),
				user.getUserType().toString(), user.getDateofBirth());
	}

	public int update(User user) {
		return jdbcTemplate.update("UPDATE USER_DETAILS SET PASSWORD = ? WHERE ID = ?", user.getPassword(), user.getId());
	}

	public int delete(User user) {
		return jdbcTemplate.update("DELETE USER_DETAILS WHERE ID = ?", user.getId());
	}
	
	public int deleteAll() {
		return jdbcTemplate.update("DELETE USER_DETAILS");
	}

	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM USER_DETAILS", (rs, rowNum) -> mapUserResult(rs));
	}

	public Optional<User> findById(Long id) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER_DETAILS WHERE ID = ?", new Object[] { id },
					(rs, rowNum) -> Optional.of(mapUserResult(rs)));
		} catch (DataAccessException e) {
			return Optional.empty();
		}
	}

	public Optional<User> findByUserName(String name) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER_DETAILS WHERE user_NAME = ?", new Object[] { name },
					(rs, rowNum) -> Optional.of(mapUserResult(rs)));
		} catch (DataAccessException e) {
			return Optional.empty();
		}
	}

	public List<User> findByUserNameAndUserType(String name, String userType) {
	
		return jdbcTemplate.query("SELECT * FROM USER_DETAILS WHERE USER_NAME = ? AND USER_TYPE = ?",
				new Object[] { name, userType }, (rs, rowNum) -> mapUserResult(rs));
	}
	
	public List<User> findAll(Sort sort) {
		Order order = sort.toList().get(0);
		return jdbcTemplate.query("SELECT * FROM USER_DETAILS ORDER BY "+order.getProperty()+" "+order.getDirection().name(),
				 (rs, rowNum) -> mapUserResult(rs));
	}
	
	public Page<User> findAll(Pageable page) {
		
		Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Order.by("ID");
		
		List<User> users = jdbcTemplate.query("SELECT * FROM USER_DETAILS ORDER BY "+order.getProperty()+" "+order.getDirection().name()
				+ " LIMIT "+page.getPageSize()+" OFFSET "+page.getOffset(),
				(rs, rowNum) -> mapUserResult(rs));
		
		return new PageImpl<User>(users, page, count());
	} 

	private User mapUserResult(final ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setUserName(rs.getString("USER_NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setCreatedTime(rs.getDate("CREATED_TIME"));
		user.setUpdatedTime(rs.getDate("UPDATED_TIME"));
		user.setUserType(UserType.valueOf(rs.getString("USER_TYPE")));
		user.setDateofBirth(rs.getDate("DOB"));

		return user;
	}

}
