package com.qf.serxlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.EmployeeService;

/**
 * Servlet implementation class EmpQueryAll
 */
@WebServlet("/EmpQueryAll")
public class EmpQueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpQueryAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        EmployeeService myemp=new EmployeeService();
		
		List<Map>  list=myemp.queryEmployeeAll();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		//查询完之后跳转到 stulist.jsp 这个页面 然后再把stulist.jsp 放到主界面中
		//带着list的数据 跳转到stulist.jsp  显示学生信息
		request.getRequestDispatcher("empList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
