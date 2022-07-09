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
		//��Ϊ��insert.jsp��� form ���е�method="post"�����������ǰ�˴�����������
		//����Ĭ�ϵı��뷽ʽ
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
			//�����ӳɹ�����ת����ʾ������Ϣ����
			response.sendRedirect("ComQueryAll");
		}
		else  {
			response.sendRedirect("insert.jsp");
		}
	}

}
