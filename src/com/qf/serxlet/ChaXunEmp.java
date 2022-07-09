package com.qf.serxlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;
import com.qf.service.EmployeeService;

/**
 * Servlet implementation class ChaXunEmp
 */
@WebServlet("/ChaXunEmp")
public class ChaXunEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXunEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入到后台了");
		request.setCharacterEncoding("utf-8");		
		String  CnameEmp=request.getParameter("CnameEmp");		
		System.out.println(CnameEmp);
		
		// 在调用查询的 StudentService 业务层 进行查询
		
		EmployeeService mycom = new  EmployeeService();
		 
		 List<Map>  list = mycom.queryEmpByName(CnameEmp);			 
		 
		 request.setAttribute("list", list);
		 
		 // 因为要带着 list的参数 跳转到   stuList.jsp页面		 
		 request.getRequestDispatcher("empList.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
