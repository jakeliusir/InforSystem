package com.qf.serxlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Testservlet
 */
@WebServlet("/Testservlet")
public class Testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("���뵽��̨��");
		String value1=request.getParameter("value1");
		String value2=request.getParameter("value2");
		System.out.println("��̨����������Ϣ��...."+value1+"..."+value2);
		request.setAttribute("name1","�����");
		request.setAttribute("name2","�����ba");
		request.setAttribute("name3","ʲô������");
	//  list  װ�ص��Ƕ��е�����
			List<Map>  list = new ArrayList<Map>();
			// ÿһ�� mapװ�ص���һ�е�����
			Map  map1 = new  HashMap();
			Map  map2 = new  HashMap();
			Map  map3 = new  HashMap();		
			
			// ��  map װ�� ÿһ�е�����
			 map1.put("name","�����");
			 map1.put("number","21080304567");
			 map1.put("subject","�������");
			 map1.put("qx","1");
			 
			
			 map2.put("name","Ҧ��");
			 map2.put("number","21080304568");
			 map2.put("subject","�������");
			 map2.put("qx","2");
			 
			 
			 map3.put("name","���л�");
			 map3.put("number","21080304569");
			 map3.put("subject","�������");
			 map3.put("qx","2");
			 
			 list.add(map1);
			 list.add(map2);
			 list.add(map3);		 
			 
			 request.setAttribute("data",list);
		
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		String date=request.getParameter("date");
		
		System.out.println(username+"...."+password+"..."+date);
	}

}
