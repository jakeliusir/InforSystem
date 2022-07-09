package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;
import com.qf.dao.EmpDao;





public class EmployeeService {
     
	//登陆的方法
	public boolean login(String username,String password)  {
		
		
	    EmpDao myuser=new  EmpDao();	
	    
	    Map map=myuser.login(username);
		//判断登陆是否正确   如果没查到用户  map是空的  map长度是0
	    if(map.size()!=0&&map.get("password").equals(password))  {
	    	
	    	return true;
	    	
	    }
		
		return false;
		
	}
	        
			//显示所有员工信息的方法
			
			public List<Map>  queryEmployeeAll()  {							
			//创建对象 加上调用方法一起来 直接返回所有员工信息
				return new EmpDao().queryAll();
			}
			public boolean addEmployee(Map map)  {
				EmpDao com=new EmpDao();
				//如果添加成功返回真，添加失败返回假值
				
				boolean flag=com.addEmployee(map);
				
				return flag;
			}
			public boolean DeleteEmployee(String id1)  {
				EmpDao myemp=new EmpDao();
				boolean flag=myemp.DeleteEmployee(id1);
				System.out.println("删除的结果是"+flag);
				return flag;
			}
			public Map queryOne(String id1)  {
				EmpDao  mycom=new EmpDao();
				
				Map map=mycom.queryOne(id1);
				
				return map;
			}
			
			public boolean UpdateEmployee(Map map)  {
				EmpDao  myemp=new EmpDao();
				
				boolean  flag=myemp.UpdateEmployee(map);
				
				return flag;	
			}
		
		
		//  根据名字查询员工	
			public  List<Map>  queryEmpByName(String value){	
				
				EmpDao  mycom = new  EmpDao();	
				
				List<Map>  list = mycom.queryEmpByName(value);
				
				return  list;
				
				
			}
		
		
	
	public static void main(String[]  args)  {
		EmployeeService  myservice=new EmployeeService();
		boolean flag=myservice.login("admin", "123456");
		System.out.println(flag);
	}
	

	
}
