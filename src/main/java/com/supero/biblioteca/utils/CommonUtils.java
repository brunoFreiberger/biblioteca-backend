package com.supero.biblioteca.utils;

public class CommonUtils {

	public static boolean isNull(String obj) {
		return obj == null || obj.trim().isEmpty();
	}
	
	public static boolean isNull(Long value) {
		return value == null;
	}
	
}
