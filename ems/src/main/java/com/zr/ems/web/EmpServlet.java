package com.zr.ems.web;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.ems.pojo.Emp;
import com.zr.ems.service.IEmpService;
import com.zr.ems.service.impl.EmpService;

@SuppressWarnings("serial")
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求的编码
		req.setCharacterEncoding("utf-8");
		// 告诉客户端如何解析服务器发送的反馈
		resp.setContentType("text/html;charset=utf-8");
		// 接受请求参数
		String cmd = req.getParameter("cmd");

		if ("login".equals(cmd)) {
			login(req, resp);

		} else if ("register".equals(cmd)) {

			register(req, resp);
		} else if ("main".equals(cmd)) {
			user(req, resp);
		} else if ("delete".equals(cmd)) {
			userdelete(req, resp);
		} else if ("updateget".equals(cmd)) {
			updateshow(req, resp);
		} else if ("update".equals(cmd)) {
			update(req, resp);
		}
		else if ("findbyid".equals(cmd)) {
			findbyid(req, resp);
		}

	}

	private void findbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		IEmpService service = new EmpService();
		Emp emp=service.findEmpById(id);
		service.findEmpById(id);
		List<Emp> list = new ArrayList<Emp>();
		list.add(emp);
		// 把集合存储到请求域中
		req.setAttribute("list", list);
		// 请求转发到查看所有信息的页面
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}

	/**
	 * 用于修改功能的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String nickname = req.getParameter("nickname");
		String gender = req.getParameter("gender");
		double salary = Double.parseDouble(req.getParameter("salary"));
		IEmpService service = new EmpService();
		// 把所有的数据封装到实体对象中
		Emp emp = new Emp(id, nickname, null, gender, salary);
		// 调用修改的方法
		service.update(emp);
		// 提示修改成功后，返回显示页面
		resp.getWriter().write("<script>alert('修改成功！'); window.location='EmpServlet?cmd=main'; window.close();</script>");
		resp.getWriter().flush();

	}

	/**
	 * 用于删除时获得原数据的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updateshow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmpService service = new EmpService();
		int id = Integer.parseInt(req.getParameter("id"));
		Emp emp = service.findEmpById(id);
		// 把提示信息放入到请求域中
		req.setAttribute("emp", emp);
		// 请求转发
		req.getRequestDispatcher("/update.jsp").forward(req, resp);

	}

	/**
	 * 用于删除功能的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void userdelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IEmpService service = new EmpService();
		int id = Integer.parseInt(req.getParameter("id"));
		service.DelByid(id);
		req.getRequestDispatcher("EmpServlet?cmd=main").forward(req, resp);

	}

	/**
	 * 用于处理注册功能的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 首先获取到前台页面传递的数据
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		double salary = Double.parseDouble(req.getParameter("salary"));

		/**
		 * 可以首先判断昵称是否已经被使用, 如果被使用, 则不允许注册.
		 */
		// 获取到服务对象
		IEmpService service = new EmpService();

		// 调用判断用户名是否存在的方法.
		// 1表示存在, 非1表示不存在
		int flag = service.findEmpByNickname(nickname);

		if (flag == 1) {

			resp.getWriter()
					.write("<script>alert('账号已经存在！'); window.location='register.jsp'; window.close();</script>");
			resp.getWriter().flush();
			return;
		} else {

			// 把所有的数据封装到实体对象中
			Emp emp = new Emp(1, nickname, password, gender, salary);

			// 调用注册的方法
			service.registerEmp(emp);
			// 提示注册成功后，返回登录页面
			resp.getWriter().write("<script>alert('注册成功！'); window.location='login.jsp'; window.close();</script>");
			resp.getWriter().flush();
		}

	}

	/**
	 * 专门用于处理登录功能的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		/**
		 * 1.获取用户名和密码 2.去数据库比对 3.如果存在则允许跳转 4.如果不存在，则告诉用户账号或密码有误
		 */

		// 1.获取用户名和密码
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");

		// 2.去数据库比对
		IEmpService service = new EmpService();

		Emp emp = service.findEmpByNicknameAndPassword(nickname, password);

		if (emp != null) {

			resp.getWriter()
					.write("<script>alert('登录成功！'); window.location='EmpServlet?cmd=main'; window.close();</script>");
			resp.getWriter().flush();

		} else {
			// resp.getWriter().write("账号或密码有误, 请检查后登录");

			resp.getWriter()
					.write("<script>alert('账号或密码有误, 请检查后登录'); window.location='login.jsp'; window.close();</script>");
			resp.getWriter().flush();
		}

	}

	/**
	 *
	 * 专门用于处理用户显示的方法
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void user(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Emp> list = null;
		IEmpService service = new EmpService();
		list = service.queryalluser();
		// 把集合存储到请求域中
		req.setAttribute("list", list);
		// 请求转发到查看所有信息的页面
		req.getRequestDispatcher("main.jsp").forward(req, resp);

	}
}
