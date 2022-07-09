package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.SaleDao;


public class SaleService {
    
	//显示所有电脑信息的方法
	
public List<Map> querySaleAll()  {	
		//创建对象 加上调用方法一起来 直接返回所有电脑信息
		return new SaleDao().queryAll();
	}
	public boolean addSale(Map map)  {
		SaleDao sale=new SaleDao();
		//如果添加成功返回真，添加失败返回假值
		
		boolean flag=sale.addSale(map);
		
		return flag;
	}
	public boolean DeleteSale(String id1)  {
		SaleDao mycom=new SaleDao();
		boolean flag=mycom.DeleteSale(id1);
		System.out.println("删除的结果是"+flag);
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
	

	
	
//	//模糊查询方法
	public List<Map> queryStuByName(String stuName){	
		SaleDao mystu=new SaleDao();	
		List<Map> list=mystu.querySaleByName(stuName);	
		return list;
			}
	
	public static void main(String[]  args)  {
		
	}
}
