package com.qf.serxlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.EmployeeService;

/**
 * Servlet implementation class updateemp1
 */
@WebServlet("/updateemp1")
public class updateemp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateemp1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println("�����id��"+id);
		//��Ҫ����ѧ����ҵ��� ������ѯȥ��ѯ ���޸�ѧ��֮ǰ����Ϣ
		EmployeeService  mycus=new  EmployeeService();
		
		//���õ�����ѯ�ķ���   ��Ҫ����id���в�ѯ   һ��Ҫ��֤id��ֵ��Ϊ��   �������ֿ�ָ���쳣
		Map map=mycus.queryOne(id);
		//��map�ں�̨�洢һ��
		
		request.setAttribute("emp", map);
		
		request.setAttribute("sex", map.get("sex"));
		
		request.getRequestDispatcher("updateemp.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
