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
 * Servlet implementation class ComQueryAll
 */
@WebServlet("/ComQueryAll")
public class ComQueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComQueryAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ѯ���е�ѧ����Ϣ
		ComputerService mycom=new ComputerService();
		
		List<Map>  list=mycom.queryComputerAll();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		//��ѯ��֮����ת�� comlist.jsp ���ҳ�� Ȼ���ٰ�comlist.jsp �ŵ���������
		//����list������ ��ת��comlist.jsp  ��ʾ������Ϣ
		request.getRequestDispatcher("comList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
