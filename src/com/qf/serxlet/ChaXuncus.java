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
		System.out.println("���뵽��̨��");
		request.setCharacterEncoding("utf-8");		
		String  CnameCus=request.getParameter("CnameCus");		
		System.out.println(CnameCus);
		
		// �ڵ��ò�ѯ�� StudentService ҵ��� ���в�ѯ
		
		CustomerService  mycom = new  CustomerService();
		 
		 List<Map>  list = mycom.queryCusByName(CnameCus);			 
		 
		 request.setAttribute("list", list);
		 
		 // ��ΪҪ���� list�Ĳ��� ��ת��   stuList.jspҳ��		 
		 request.getRequestDispatcher("cusList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
