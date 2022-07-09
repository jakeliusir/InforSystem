package com.qf.serxlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;
import com.qf.service.SaleService;

/**
 * Servlet implementation class updateSale2
 */
@WebServlet("/updateSale2")
public class updateSale2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSale2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 String id = request.getParameter("id");
		 String computer_name = request.getParameter("computer_name");
		 String price = request.getParameter("price");
		 String sales = request.getParameter("sales");
		 String sale_name = request.getParameter("sale_name");
		 String date = request.getParameter("date");
		 
		 
		// 创建map参数 存储添加的信息
		 Map map = new HashMap(); 
			map.put("id", id);
			map.put("computer_name", computer_name);
			map.put("sales", sales);
			map.put("price", price);
			map.put("date", date);
			map.put("sale_name", sale_name);
			
		// 创建 StuService的变量
		    SaleService  mycom = new SaleService();
		    mycom.UpdateSale(map);
		// 先跳转到查询全部信息的后台，然后通过全部信息的后台 再跳转到显示页面
		 response.sendRedirect("SaleQueryAll");
	}

}
