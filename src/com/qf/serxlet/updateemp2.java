package com.qf.serxlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.EmployeeService;

/**
 * Servlet implementation class updateemp2
 */
@WebServlet("/updateemp2")
public class updateemp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateemp2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 String id = request.getParameter("id");
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 String phone = request.getParameter("phone");
		 String section = request.getParameter("section");
		 
		 
		// ����map���� �洢��ӵ���Ϣ
		 Map map = new HashMap();
			map.put("id", id);
			map.put("username", username);
			map.put("password", password);
			map.put("phone", phone);
			map.put("section", section);
		 
		// ���� StuService�ı���
		   EmployeeService  myemp = new EmployeeService();
		 myemp.UpdateEmployee(map);
		// ����ת����ѯȫ����Ϣ�ĺ�̨��Ȼ��ͨ��ȫ����Ϣ�ĺ�̨ ����ת����ʾҳ��
		 response.sendRedirect("EmpQueryAll");
	}

}
