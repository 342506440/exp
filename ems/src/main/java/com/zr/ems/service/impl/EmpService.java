package com.zr.ems.service.impl;

import java.util.List;

import com.zr.ems.dao.IEmpDao;
import com.zr.ems.dao.impl.EmpDao;
import com.zr.ems.pojo.Emp;
import com.zr.ems.service.IEmpService;

/**
 * 
 * 服务接口的实现类
 * 
 * @author Administrator
 */
public class EmpService implements IEmpService {
	// 获取到专门处理持久层方面的对象
	IEmpDao empDao = new EmpDao();
	@Override
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {

		// 调用dao中的方法
		return empDao.findEmpByNicknameAndPassword(nickname, password);
	}

	@Override
	public int findEmpByNickname(String nickname) {

		// 调用dao中的方法
		return empDao.findEmpByNickname(nickname);
	}

	@Override
	public void registerEmp(Emp emp) {
		
		// 调用dao中的方法
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
