package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;

public class ComputerService {
        
	//显示所有电脑信息的方法
	
	public List<Map>  queryComputerAll()  {
		
		
		
		//创建对象 加上调用方法一起来 直接返回所有电脑信息
		return new ComDao().queryAll();
	}
	public boolean addComputer(Map map)  {
		ComDao com=new ComDao();
		//如果添加成功返回真，添加失败返回假值
		
		boolean flag=com.addComputer(map);
		
		return flag;
	}
	public boolean DeleteComputer(String id1)  {
		ComDao mycom=new ComDao();
		boolean flag=mycom.DeleteComputer(id1);
		System.out.println("删除的结果是"+flag);
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
	
//  根据名字查询电脑	
	public  List<Map>  queryComByName(String combrand){	
		
		ComDao  mycom = new  ComDao();	
		
		List<Map>  list = mycom.queryComByName(combrand);
		System.out.println("list"+list);
		
		return  list;
		
		
	}
	
	
	public static void main(String[]  args)  {
		
	}
}
