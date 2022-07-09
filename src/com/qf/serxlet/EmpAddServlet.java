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
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAddServlet() {
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
		
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		String qx=request.getParameter("qx");
		
		String phone=request.getParameter("phone");
		
		String section=request.getParameter("section");
		
		System.out.println(username+"......"+password+"....."+qx+"......"+phone+"......"+section);
		
		EmployeeService  myemp=new EmployeeService();
		
		Map map=new HashMap();
		map.put("username", username);
		map.put("password", password);
		map.put("qx", qx);
		map.put("phone", phone);
		map.put("section", section);
		
		boolean flag =myemp.addEmployee(map);
		
		if(flag=true)   {
			//如果添加成功，跳转到显示所以信息界面
			response.sendRedirect("EmpQueryAll");
		}
		else  {
			response.sendRedirect("insertEmp.jsp");
	}

}
}
