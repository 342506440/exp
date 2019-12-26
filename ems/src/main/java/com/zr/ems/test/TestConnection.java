package com.zr.ems.test;

import java.sql.Connection;

import com.zr.ems.utils.MyDBUtils;

public class TestConnection {

	public static void main(String args) {
		Connection connection =MyDBUtils.getConnection();
		System.out.println(connection);
	}
}
