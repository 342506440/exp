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
		// ��������ı���
		req.setCharacterEncoding("utf-8");
		// ���߿ͻ�����ν������������͵ķ���
		resp.setContentType("text/html;charset=utf-8");
		// �����������
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
		// �Ѽ��ϴ洢����������
		req.setAttribute("list", list);
		// ����ת�����鿴������Ϣ��ҳ��
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}

	/**
	 * �����޸Ĺ��ܵķ���
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
		// �����е����ݷ�װ��ʵ�������
		Emp emp = new Emp(id, nickname, null, gender, salary);
		// �����޸ĵķ���
		service.update(emp);
		// ��ʾ�޸ĳɹ��󣬷�����ʾҳ��
		resp.getWriter().write("<script>alert('�޸ĳɹ���'); window.location='EmpServlet?cmd=main'; window.close();</script>");
		resp.getWriter().flush();

	}

	/**
	 * ����ɾ��ʱ���ԭ���ݵķ���
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
		// ����ʾ��Ϣ���뵽��������
		req.setAttribute("emp", emp);
		// ����ת��
		req.getRequestDispatcher("/update.jsp").forward(req, resp);

	}

	/**
	 * ����ɾ�����ܵķ���
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
	 * ���ڴ���ע�Ṧ�ܵķ���
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���Ȼ�ȡ��ǰ̨ҳ�洫�ݵ�����
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		double salary = Double.parseDouble(req.getParameter("salary"));

		/**
		 * ���������ж��ǳ��Ƿ��Ѿ���ʹ��, �����ʹ��, ������ע��.
		 */
		// ��ȡ���������
		IEmpService service = new EmpService();

		// �����ж��û����Ƿ���ڵķ���.
		// 1��ʾ����, ��1��ʾ������
		int flag = service.findEmpByNickname(nickname);

		if (flag == 1) {

			resp.getWriter()
					.write("<script>alert('�˺��Ѿ����ڣ�'); window.location='register.jsp'; window.close();</script>");
			resp.getWriter().flush();
			return;
		} else {

			// �����е����ݷ�װ��ʵ�������
			Emp emp = new Emp(1, nickname, password, gender, salary);

			// ����ע��ķ���
			service.registerEmp(emp);
			// ��ʾע��ɹ��󣬷��ص�¼ҳ��
			resp.getWriter().write("<script>alert('ע��ɹ���'); window.location='login.jsp'; window.close();</script>");
			resp.getWriter().flush();
		}

	}

	/**
	 * ר�����ڴ����¼���ܵķ���
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		/**
		 * 1.��ȡ�û��������� 2.ȥ���ݿ�ȶ� 3.���������������ת 4.��������ڣ�������û��˺Ż���������
		 */

		// 1.��ȡ�û���������
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");

		// 2.ȥ���ݿ�ȶ�
		IEmpService service = new EmpService();

		Emp emp = service.findEmpByNicknameAndPassword(nickname, password);

		if (emp != null) {

			resp.getWriter()
					.write("<script>alert('��¼�ɹ���'); window.location='EmpServlet?cmd=main'; window.close();</script>");
			resp.getWriter().flush();

		} else {
			// resp.getWriter().write("�˺Ż���������, ������¼");

			resp.getWriter()
					.write("<script>alert('�˺Ż���������, ������¼'); window.location='login.jsp'; window.close();</script>");
			resp.getWriter().flush();
		}

	}

	/**
	 *
	 * ר�����ڴ����û���ʾ�ķ���
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
		// �Ѽ��ϴ洢����������
		req.setAttribute("list", list);
		// ����ת�����鿴������Ϣ��ҳ��
		req.getRequestDispatcher("main.jsp").forward(req, resp);

	}
}
