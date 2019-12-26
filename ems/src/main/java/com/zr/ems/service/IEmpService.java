package com.zr.ems.service;
import java.util.List;

import com.zr.ems.pojo.Emp;

/**
 * 服务接口 
 *
 */
public interface IEmpService {


	/**
	 * 通过账号和密码查找emp对象
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpByNicknameAndPassword(String nickname, String password);

	/**
	 * 根据昵称判断用户是否存在
	 * 
	 * @param nickname
	 * @return
	 */
	int findEmpByNickname(String nickname);

	/**
	 * 注册员工信息
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);

	/**
	 * 显示所有信息
	 * 
	 * @param emp
	 */
	List<Emp> queryalluser();

	/**
	 *根据ID删除某一条信息
	 * 
	 * @param emp
	 */
	void DelByid(int id);

	/**
	 * 通过ID查找emp对象
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpById(int id);

	/**
	 * 修改emp对象
	 * @param nickname
	 * @param password
	 * @return
	 */
	void update(Emp emp);


}
