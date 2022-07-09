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
import com.qf.service.SaleService;

/**
 * Servlet implementation class SaleQueryAll
 */
@WebServlet("/SaleQueryAll")
public class SaleQueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleQueryAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ѯ���е���������Ϣ
				SaleService mycom=new SaleService();
				
				List<Map>  list=mycom.querySaleAll();
				
				System.out.println(list);
				
				request.setAttribute("list", list);
				//��ѯ��֮����ת�� comlist.jsp ���ҳ�� Ȼ���ٰ�comlist.jsp �ŵ���������
				//����list������ ��ת��comlist.jsp  ��ʾ������Ϣ
				request.getRequestDispatcher("saleList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
