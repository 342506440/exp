package com.zr.ems.service.impl;

import java.util.List;

import com.zr.ems.dao.IEmpDao;
import com.zr.ems.dao.impl.EmpDao;
import com.zr.ems.pojo.Emp;
import com.zr.ems.service.IEmpService;

/**
 * 
 * ����ӿڵ�ʵ����
 * 
 * @author Administrator
 */
public class EmpService implements IEmpService {
	// ��ȡ��ר�Ŵ���־ò㷽��Ķ���
	IEmpDao empDao = new EmpDao();
	@Override
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {

		// ����dao�еķ���
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}

	@Override
	public int findEmpByNickname(String nickname) {

		// ����dao�еķ���
		return empDao.findEmpByNickname(nickname);
	}

	@Override
	public void registerEmp(Emp emp) {
		
		// ����dao�еķ���
		 empDao.registerEmp(emp);

	}

	@Override
	public List<Emp> queryalluser() {
		 
		return empDao.queryalluser();
	}

	@Override
	public void DelByid(int id) {
		empDao.DelByid(id);
		
	}

	@Override
	public Emp findEmpById(int id) {
		return empDao.findEmpById(id);
	}

	@Override
	public void update(Emp emp) {
		empDao.update(emp);
		
	}

}
