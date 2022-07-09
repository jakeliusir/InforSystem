package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;
import com.qf.dao.CusDao;

public class CustomerService {

	public List<Map>  queryCustomerAll()  {
		
		
		
		//�������� ���ϵ��÷���һ���� ֱ�ӷ������й˿���Ϣ
		return new CusDao().queryAll();
	}
	public boolean addCustomer(Map map)  {
		CusDao stu=new CusDao();
		//�����ӳɹ������棬���ʧ�ܷ��ؼ�ֵ
		
		boolean flag=stu.addCustomer(map);
		
		return flag;
	}
	public boolean DeleteCustomer(String id1)  {
		CusDao mystu=new CusDao();
		boolean flag=mystu.DeleteCustomer(id1);
		System.out.println("ɾ���Ľ����"+flag);
		return flag;
	}
	public Map queryOne(String id1)  {
		CusDao  mycus=new CusDao();
		
		Map map=mycus.queryOne(id1);
		
		return map;
	}
	
	
	public boolean UpdateCustomer(Map map)  {
		CusDao  mycus=new CusDao();
		
		boolean  flag=mycus.UpdateCustomer(map);
		
		return flag;
		
	}
	
	
public  List<Map>  queryCusByName(String cus){	
		
		CusDao  mycom = new  CusDao();	
		
		List<Map>  list = mycom.queryCusByName(cus);
		
		return  list;
		
		
	}
	
	
	
	public static void main(String[]  args)  {
		
	}
}
