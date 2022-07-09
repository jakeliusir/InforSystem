package com.qf.serxlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.CustomerService;

/**
 * Servlet implementation class ChaXuncus
 */
@WebServlet("/ChaXuncus")
public class ChaXuncus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXuncus() {
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
		String  CnameCus=request.getParameter("CnameCus");		
		System.out.println(CnameCus);
		
		// 在调用查询的 StudentService 业务层 进行查询
		
		CustomerService  mycom = new  CustomerService();
		 
		 List<Map>  list = mycom.queryCusByName(CnameCus);			 
		 
		 request.setAttribute("list", list);
		 
		 // 因为要带着 list的参数 跳转到   stuList.jsp页面		 
		 request.getRequestDispatcher("cusList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
