package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.SaleDao;


public class SaleService {
    
	//��ʾ���е�����Ϣ�ķ���
	
public List<Map> querySaleAll()  {	
		//�������� ���ϵ��÷���һ���� ֱ�ӷ������е�����Ϣ
		return new SaleDao().queryAll();
	}
	public boolean addSale(Map map)  {
		SaleDao sale=new SaleDao();
		//�����ӳɹ������棬���ʧ�ܷ��ؼ�ֵ
		
		boolean flag=sale.addSale(map);
		
		return flag;
	}
	public boolean DeleteSale(String id1)  {
		SaleDao mycom=new SaleDao();
		boolean flag=mycom.DeleteSale(id1);
		System.out.println("ɾ���Ľ����"+flag);
		return flag;
	}
	public Map queryOne(String id1)  {
		SaleDao mycom=new SaleDao();
		
		Map map=mycom.queryOne(id1);
		
		return map;
	}
	
	public boolean UpdateSale(Map map)  {
		SaleDao mycom=new SaleDao();
		
		boolean  flag=mycom.UpdateSale(map);
		
		return flag;
		
	}
	

	
	
//	//ģ����ѯ����
	public List<Map> queryStuByName(String stuName){	
		SaleDao mystu=new SaleDao();	
		List<Map> list=mystu.querySaleByName(stuName);	
		return list;
			}
	
	public static void main(String[]  args)  {
		
	}
}
