package com.qf.serxlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.CustomerService;

/**
 * Servlet implementation class CusAddServlet
 */
@WebServlet("/CusAddServlet")
public class CusAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusAddServlet() {
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
request.setCharacterEncoding("utf-8");
		
		String �˿�=request.getParameter("�˿�");
		
		String �Ӵ���=request.getParameter("�Ӵ���");
		
		String ����Ʒ��=request.getParameter("����Ʒ��");
		
		String �۸�=request.getParameter("�۸�");
		
		System.out.println(�˿�+"......"+�Ӵ���+"....."+����Ʒ��+"....."+�۸�);
		
		CustomerService  mycus=new CustomerService();
		
		Map map=new HashMap();
		map.put("�˿�", �˿�);
		map.put("�Ӵ���", �Ӵ���);
		map.put("����Ʒ��", ����Ʒ��);
		map.put("�۸�", �۸�);
		
		boolean flag =mycus.addCustomer(map);
		
		if(flag=true)   {
			//�����ӳɹ�����ת����ʾ������Ϣ����
			response.sendRedirect("CusQueryAll");
		}
		else  {
			response.sendRedirect("insertCus.jsp");
		}
	}

}
