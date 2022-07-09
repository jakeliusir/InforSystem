package com.qf.serxlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;

/**
 * Servlet implementation class DeleteComServlet
 */
@WebServlet("/DeleteComServlet")
public class DeleteComServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComServlet() {
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
		ComputerService mycom=new ComputerService();
		
		boolean flag = mycom.DeleteComputer(id);
		
		//������ת����ѯ�ĺ�̨
		response.sendRedirect("ComQueryAll");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
