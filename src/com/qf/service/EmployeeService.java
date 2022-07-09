package com.qf.service;

import java.util.List;
import java.util.Map;

import com.qf.dao.ComDao;
import com.qf.dao.EmpDao;





public class EmployeeService {
     
	//��½�ķ���
	public boolean login(String username,String password)  {
		
		
	    EmpDao myuser=new  EmpDao();	
	    
	    Map map=myuser.login(username);
		//�жϵ�½�Ƿ���ȷ   ���û�鵽�û�  map�ǿյ�  map������0
	    if(map.size()!=0&&map.get("password").equals(password))  {
	    	
	    	return true;
	    	
	    }
		
		return false;
		
	}
	        
			//��ʾ����Ա����Ϣ�ķ���
			
			public List<Map>  queryEmployeeAll()  {							
			//�������� ���ϵ��÷���һ���� ֱ�ӷ�������Ա����Ϣ
				return new EmpDao().queryAll();
			}
			public boolean addEmployee(Map map)  {
				EmpDao com=new EmpDao();
				//�����ӳɹ������棬���ʧ�ܷ��ؼ�ֵ
				
				boolean flag=com.addEmployee(map);
				
				return flag;
			}
			public boolean DeleteEmployee(String id1)  {
				EmpDao myemp=new EmpDao();
				boolean flag=myemp.DeleteEmployee(id1);
				System.out.println("ɾ���Ľ����"+flag);
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
		
		
		//  �������ֲ�ѯԱ��	
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
