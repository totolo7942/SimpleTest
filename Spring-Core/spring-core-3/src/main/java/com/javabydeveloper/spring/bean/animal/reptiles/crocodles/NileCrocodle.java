package com.javabydeveloper.spring.bean.animal.reptiles.crocodles;

import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.bean.animal.reptiles.Crocodle;

@Component
public class NileCrocodle extends Crocodle{

	@Override
	public String toString() {
		return "NileCrocodle";
	}
}