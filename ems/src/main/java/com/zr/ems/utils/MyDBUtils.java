package com.zr.ems.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接数据库的工具类
 */
public class MyDBUtils {

	public static String driver;
	public static String url;
	public static String username;
	public static String password;

	// 用于储存db.properties文件中数据的集合
	private static Properties properties = new Properties();

	/**
	 * 私有构造方法
	 */
	private MyDBUtils() {
	}

	static {
		try {
			// 读取db.properties文件
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");

			// 把读取到的db.properties文件中的数据加入到Properties集合中
			properties.load(is);

			// 把数据读取到数据赋值程序中
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			// 注册驱动
			Class.forName(driver);

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 调用该方法就获取到数据库的连接对象
	 * @return
	 */
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
