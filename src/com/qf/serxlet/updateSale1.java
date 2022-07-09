package com.qf.serxlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.ComputerService;
import com.qf.service.SaleService;

/**
 * Servlet implementation class updateSale1
 */
@WebServlet("/updateSale1")
public class updateSale1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSale1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ǰ�˴�������id
				String id=request.getParameter("id");
				System.out.println("�����id��"+id);
				//��Ҫ����ѧ����ҵ��� ������ѯȥ��ѯ ���޸�ѧ��֮ǰ����Ϣ
				SaleService  mystu=new  SaleService();
				
				//���õ�����ѯ�ķ���   ��Ҫ����id���в�ѯ   һ��Ҫ��֤id��ֵ��Ϊ��   �������ֿ�ָ���쳣
				Map map=mystu.queryOne(id);
				//��map�ں�̨�洢һ��
				
				request.setAttribute("sale", map);
				
				request.setAttribute("sex", map.get("sex"));
				
				request.getRequestDispatcher("updateSale.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
