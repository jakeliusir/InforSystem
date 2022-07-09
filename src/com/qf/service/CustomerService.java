package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;
import com.qf.dao.CusDao;

public class CustomerService {

	public List<Map>  queryCustomerAll()  {
		
		
		
		//创建对象 加上调用方法一起来 直接返回所有顾客信息
		return new CusDao().queryAll();
	}
	public boolean addCustomer(Map map)  {
		CusDao stu=new CusDao();
		//如果添加成功返回真，添加失败返回假值
		
		boolean flag=stu.addCustomer(map);
		
		return flag;
	}
	public boolean DeleteCustomer(String id1)  {
		CusDao mystu=new CusDao();
		boolean flag=mystu.DeleteCustomer(id1);
		System.out.println("删除的结果是"+flag);
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
