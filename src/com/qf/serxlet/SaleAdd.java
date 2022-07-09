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
 * Servlet implementation class SaleAdd
 */
@WebServlet("/SaleAdd")
public class SaleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAdd() {
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
		//��Ϊ��insert.jsp��� form ���е�method="post"�����������ǰ�˴�����������
		//����Ĭ�ϵı��뷽ʽ
		request.setCharacterEncoding("utf-8");
		
		String computer_name=request.getParameter("computer_name");
		
		String price=request.getParameter("price");
		
		String sales=request.getParameter("sales");
		String sale_name=request.getParameter("sale_name");
		String date=request.getParameter("date");
		
		System.out.println(computer_name+"......"+price+"....."+sales);
		
		SaleService  mycom=new SaleService();
		
		Map map=new HashMap();
		map.put("computer_name", computer_name);
		map.put("price", price);
		map.put("sales", sales);
		map.put("sale_name", sale_name);
		map.put("date", date);
		
		boolean flag =mycom.addSale(map);
		
		if(flag=true)   {
			//�����ӳɹ�����ת����ʾ������Ϣ����
			response.sendRedirect("SaleQueryAll");
		}
		else  {
			response.sendRedirect("insert.jsp");
		}
	}

}
