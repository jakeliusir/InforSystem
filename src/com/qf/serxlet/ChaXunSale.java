package com.qf.serxlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.SaleService;

/**
 * Servlet implementation class ChaXunSale
 */
@WebServlet("/ChaXunSale")
public class ChaXunSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXunSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("���뵽��̨��");
		request.setCharacterEncoding("utf-8");
		String  Cname=request.getParameter("Cname");		
		System.out.println("Cname"+Cname);
		
		// �ڵ��ò�ѯ�� StudentService ҵ��� ���в�ѯ
		
		SaleService  mysale = new  SaleService();
		 List<Map>  list = mysale.queryStuByName(Cname);		
			System.out.println("list"+list);

		 request.setAttribute("list", list);

		
		 // ��ΪҪ���� list1�Ĳ��� ��ת��   stuList.jspҳ��		 
		 request.getRequestDispatcher("saleList.jsp").forward(request, response);
		
			System.out.println("���뵽��̨��5");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
