package com.javabydeveloper.template;

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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javabydeveloper.model.User;
import com.javabydeveloper.util.UserType;

@Repository
public class UserNamedParameterJdbcTemplate {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM USER", new MapSqlParameterSource(), Integer.class);
	}

	public int save(User user) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("userName", user.getUserName());
		mapSqlParameterSource.addValue("password", user.getPassword());
		mapSqlParameterSource.addValue("createdTime", user.getCreatedTime());
		mapSqlParameterSource.addValue("userType", user.getUserType().toString());
		mapSqlParameterSource.addValue("dateofBirth", user.getDateofBirth());

		return jdbcTemplate.update("INSERT INTO `USER` (USERNAME, PASSWORD, CREATEDTIME, USERTYPE, DATEOFBIRTH)"
				+ " VALUES(:userName,:password,:createdTime,:userType,:dateofBirth)", mapSqlParameterSource);
	}

	public int update(User user) {

		return jdbcTemplate.update("UPDATE USER SET PASSWORD = :password WHERE ID = :id",
				new BeanPropertySqlParameterSource(user));
	}

	public int delete(User user) {
		return jdbcTemplate.update("DELETE FROM USER WHERE ID = :id", new MapSqlParameterSource("id", user.getId()));
	}

	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM USER", (rs, rowNum) -> mapUserResult(rs));
	}

	public Optional<User> findById(Long id) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = :id", new MapSqlParameterSource("id", id),
					(rs, rowNum) -> Optional.of(mapUserResult(rs)));
		} catch (DataAccessException e) {
			return Optional.empty();
		}
	}

	public Optional<User> findByUserName(String name) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USERNAME = :name",
					new MapSqlParameterSource("name", name), (rs, rowNum) -> Optional.of(mapUserResult(rs)));
		} catch (DataAccessException e) {
			return Optional.empty();
		}
	}

	public List<User> findByUserNameAndUserType(String name, String userType) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("name", name);
		mapSqlParameterSource.addValue("type", userType);
		return jdbcTemplate.query("SELECT * FROM USER WHERE USERNAME = :name AND USERTYPE = :type", mapSqlParameterSource,
				(rs, rowNum) -> mapUserResult(rs));
	}
	
	public List<User> findAllSorted(Sort sort) {
		Order order = sort.toList().get(0);
		return jdbcTemplate.query("SELECT * FROM USER ORDER BY "+order.getProperty()+" "+order.getDirection().name(),
				 (rs, rowNum) -> mapUserResult(rs));
	}
	
	public Page<User> findAllPaginated(Pageable page) {
	
		List<User> users = jdbcTemplate.query("SELECT * FROM USER LIMIT "+page.getPageSize()+" OFFSET "+page.getOffset(),
				(rs, rowNum) -> mapUserResult(rs));
		
		return new PageImpl<User>(users, page, count());
	}
	
	public Page<User> findAllPaginatedAndSorted(Pageable page) {
		Order order = page.getSort().toList().get(0);
		List<User> users = jdbcTemplate.query("SELECT * FROM USER ORDER BY "+order.getProperty()+" "+order.getDirection().name()
				+ " LIMIT "+page.getPageSize()+" OFFSET "+page.getOffset(),
				(rs, rowNum) -> mapUserResult(rs));
		
		return new PageImpl<User>(users, page, count());
	}

	private User mapUserResult(final ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setCreatedTime(rs.getDate("CREATEDTIME"));
		user.setUpdatedTime(rs.getDate("UPDATEDTIME"));
		user.setUserType(UserType.valueOf(rs.getString("USERTYPE")));
		user.setDateofBirth(rs.getDate("DATEOFBIRTH"));

		return user;
	}

}
