package com.zr.ems.service;
import java.util.List;

import com.zr.ems.pojo.Emp;

/**
 * ����ӿ� 
 *
 */
public interface IEmpService {


	/**
	 * ͨ���˺ź��������emp����
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpByNicknameAndPassword(String nickname, String password);

	/**
	 * �����ǳ��ж��û��Ƿ����
	 * 
	 * @param nickname
	 * @return
	 */
	int findEmpByNickname(String nickname);

	/**
	 * ע��Ա����Ϣ
	 * 
	 * @param emp
	 */
	void registerEmp(Emp emp);

	/**
	 * ��ʾ������Ϣ
	 * 
	 * @param emp
	 */
	List<Emp> queryalluser();

	/**
	 *����IDɾ��ĳһ����Ϣ
	 * 
	 * @param emp
	 */
	void DelByid(int id);

	/**
	 * ͨ��ID����emp����
	 * @param nickname
	 * @param password
	 * @return
	 */
	Emp findEmpById(int id);

	/**
	 * �޸�emp����
	 * @param nickname
	 * @param password
	 * @return
	 */
	void update(Emp emp);


}
