package com.qf.serxlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.CustomerService;

/**
 * Servlet implementation class updatecus2
 */
@WebServlet("/updatecus2")
public class updatecus2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecus2() {
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
		 String 顾客 = request.getParameter("顾客");
		 String 接待人 = request.getParameter("接待人");
		 String 电脑品牌 = request.getParameter("电脑品牌");
		 String 价格 = request.getParameter("价格");
		 
		 
		// 创建map参数 存储添加的信息
		 Map map = new HashMap();
			map.put("id", id);
			map.put("顾客", 顾客);
			map.put("接待人", 接待人);
			map.put("电脑品牌", 电脑品牌);
			map.put("价格", 价格);
		 
		// 创建 StuService的变量
		   CustomerService  mycus = new CustomerService();
		 mycus.UpdateCustomer(map);
		// 先跳转到查询全部信息的后台，然后通过全部信息的后台 再跳转到显示页面
		 response.sendRedirect("CusQueryAll");
	}

}
