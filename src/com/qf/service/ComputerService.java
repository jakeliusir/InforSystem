package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;

public class ComputerService {
        
	//��ʾ���е�����Ϣ�ķ���
	
	public List<Map>  queryComputerAll()  {
		
		
		
		//�������� ���ϵ��÷���һ���� ֱ�ӷ������е�����Ϣ
		return new ComDao().queryAll();
	}
	public boolean addComputer(Map map)  {
		ComDao com=new ComDao();
		//�����ӳɹ������棬���ʧ�ܷ��ؼ�ֵ
		
		boolean flag=com.addComputer(map);
		
		return flag;
	}
	public boolean DeleteComputer(String id1)  {
		ComDao mycom=new ComDao();
		boolean flag=mycom.DeleteComputer(id1);
		System.out.println("ɾ���Ľ����"+flag);
		return flag;
	}
	public Map queryOne(String id1)  {
		ComDao  mycom=new ComDao();
		
		Map map=mycom.queryOne(id1);
		
		return map;
	}
	
	public boolean UpdateComputer(Map map)  {
		ComDao  mycom=new ComDao();
		
		boolean  flag=mycom.UpdateComputer(map);
		
		return flag;
		
	}
	
//  �������ֲ�ѯ����	
	public  List<Map>  queryComByName(String combrand){	
		
		ComDao  mycom = new  ComDao();	
		
		List<Map>  list = mycom.queryComByName(combrand);
		System.out.println("list"+list);
		
		return  list;
		
		
	}
	
	
	public static void main(String[]  args)  {
		
	}
}
