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

/**
 * Servlet implementation class StuAddServlet
 */
@WebServlet("/StuAddServlet")
public class ComAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComAddServlet() {
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
		//因为在insert.jsp里边 form 表单中的method="post"所以在这接收前端传过来的数据
		//设置默认的编码方式
		request.setCharacterEncoding("utf-8");
		
		String brand=request.getParameter("brand");
		
		String price=request.getParameter("price");
		
		String color=request.getParameter("color");
		
		System.out.println(brand+"......"+price+"....."+color);
		
		ComputerService  mycom=new ComputerService();
		
		Map map=new HashMap();
		map.put("brand", brand);
		map.put("price", price);
		map.put("color", color);
		
		boolean flag =mycom.addComputer(map);
		
		if(flag=true)   {
			//如果添加成功，跳转到显示所以信息界面
			response.sendRedirect("ComQueryAll");
		}
		else  {
			response.sendRedirect("insert.jsp");
		}
	}

}
