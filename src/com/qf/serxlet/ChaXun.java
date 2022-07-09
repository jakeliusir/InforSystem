package com.qf.serxlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;

/**
 * Servlet implementation class ChaXun
 */
@WebServlet("/ChaXun")
public class ChaXun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXun() {
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
		String  Cbrand=request.getParameter("Cbrand");		
		System.out.println(Cbrand);
		
		// �ڵ��ò�ѯ�� StudentService ҵ��� ���в�ѯ
		
		ComputerService  mycom = new  ComputerService();
		 
		 List<Map>  list = mycom.queryComByName(Cbrand);			 
		 
		 request.setAttribute("list", list);
			System.out.println("list"+list);
		 System.out.println("���뵽��̨��com");
		 // ��ΪҪ���� list�Ĳ��� ��ת��   stuList.jspҳ��		 
		 request.getRequestDispatcher("comList.jsp").forward(request, response);
		 System.out.println("���뵽��̨��com1");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
