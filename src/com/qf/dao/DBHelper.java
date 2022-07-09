package com.qf.dao;
import java.sql.*;
public class DBHelper {
// 连接数据库的常量参数
	//连接数据库的用户名
	private static final String username="root";
	private static final String password="123456";
	private  static  final  String drive = "com.mysql.jdbc.Driver";
	//连接数据库的url 地址
	private  static  final String url = "jdbc:mysql://127.0.0.1:3306/computer?characterEncoding=utf8";
	//连接数据库类
	public Connection conn=null;
	
	public PreparedStatement pst=null;
	
	public DBHelper(String sql)  throws Exception{
		Class.forName(drive);
		
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("数据库连接成功");
		pst=conn.prepareStatement(sql);
		System.out.println("Sql语句检验成功");
		
	}
	public void close()    {
		
		if(conn!=null)  {
			
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	public static void main(String[] args)  throws Exception  {
		DBHelper db=new  DBHelper("select  * from student");
	}	
}
