package com.qf.serxlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.EmployeeService;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
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
		
		String username =request.getParameter("username");
		
		String password =request.getParameter("password");
		
		//需要和后台的数据进行对比实现登录功能
		//需要在Dao层写一个登录方法，得用user表里的数据
		//在业务层里扩展相应的功能
		
		System.out.println(username+"......"+password);
		
		EmployeeService myservice=new EmployeeService();
		boolean flag=   myservice.login(username,password);
		if(flag)  {
			request.setAttribute("msg","用户名或密码错误");
			//如果出现复杂的页面结构可以用Session去存储 因为有效时间更长
			request.getSession().setAttribute("nickname", username);
			request.getRequestDispatcher("showInfo.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msg","用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
