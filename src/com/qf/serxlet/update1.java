package com.qf.serxlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;

/**
 * Servlet implementation class update1
 */
@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收前端传过来的id
		String id=request.getParameter("id");
		System.out.println("输出的id是"+id);
		//需要调用学生端业务层 单条查询去查询 被修改学生之前的信息
		ComputerService  mystu=new  ComputerService();
		
		//调用单条查询的方法   需要根据id进行查询   一定要保证id的值不为空   否则会出现空指针异常
		Map map=mystu.queryOne(id);
		//将map在后台存储一下
		
		request.setAttribute("com", map);
		
		request.setAttribute("sex", map.get("sex"));
		
		request.getRequestDispatcher("update.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
