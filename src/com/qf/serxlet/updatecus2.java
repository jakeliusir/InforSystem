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
 * Servlet implementation class updatecus2
 */
@WebServlet("/updatecus2")
public class updatecus2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecus2() {
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
		 String id = request.getParameter("id");
		 String �˿� = request.getParameter("�˿�");
		 String �Ӵ��� = request.getParameter("�Ӵ���");
		 String ����Ʒ�� = request.getParameter("����Ʒ��");
		 String �۸� = request.getParameter("�۸�");
		 
		 
		// ����map���� �洢��ӵ���Ϣ
		 Map map = new HashMap();
			map.put("id", id);
			map.put("�˿�", �˿�);
			map.put("�Ӵ���", �Ӵ���);
			map.put("����Ʒ��", ����Ʒ��);
			map.put("�۸�", �۸�);
		 
		// ���� StuService�ı���
		   CustomerService  mycus = new CustomerService();
		 mycus.UpdateCustomer(map);
		// ����ת����ѯȫ����Ϣ�ĺ�̨��Ȼ��ͨ��ȫ����Ϣ�ĺ�̨ ����ת����ʾҳ��
		 response.sendRedirect("CusQueryAll");
	}

}
