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
 * Servlet implementation class CusAddServlet
 */
@WebServlet("/CusAddServlet")
public class CusAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusAddServlet() {
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
		
		String 顾客=request.getParameter("顾客");
		
		String 接待人=request.getParameter("接待人");
		
		String 电脑品牌=request.getParameter("电脑品牌");
		
		String 价格=request.getParameter("价格");
		
		System.out.println(顾客+"......"+接待人+"....."+电脑品牌+"....."+价格);
		
		CustomerService  mycus=new CustomerService();
		
		Map map=new HashMap();
		map.put("顾客", 顾客);
		map.put("接待人", 接待人);
		map.put("电脑品牌", 电脑品牌);
		map.put("价格", 价格);
		
		boolean flag =mycus.addCustomer(map);
		
		if(flag=true)   {
			//如果添加成功，跳转到显示所以信息界面
			response.sendRedirect("CusQueryAll");
		}
		else  {
			response.sendRedirect("insertCus.jsp");
		}
	}

}
