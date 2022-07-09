package com.qf.serxlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;
import com.qf.service.SaleService;

/**
 * Servlet implementation class DeleteSaleServlet
 */
@WebServlet("/DeleteSaleServlet")
public class DeleteSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String id =request.getParameter("id");
		
		System.out.println("ɾ����id�ǣ�"+id);
	 
		//����ҵ���ɾ������
		SaleService mycom=new SaleService();
		
		boolean flag = mycom.DeleteSale(id);
		
		//������ת����ѯ�ĺ�̨
		response.sendRedirect("SaleQueryAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
