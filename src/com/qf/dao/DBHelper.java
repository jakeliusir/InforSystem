package com.qf.dao;
import java.sql.*;
public class DBHelper {
// �������ݿ�ĳ�������
	//�������ݿ���û���
	private static final String username="root";
	private static final String password="123456";
	private  static  final  String drive = "com.mysql.jdbc.Driver";
	//�������ݿ��url ��ַ
	private  static  final String url = "jdbc:mysql://127.0.0.1:3306/computer?characterEncoding=utf8";
	//�������ݿ���
	public Connection conn=null;
	
	public PreparedStatement pst=null;
	
	public DBHelper(String sql)  throws Exception{
		Class.forName(drive);
		
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("���ݿ����ӳɹ�");
		pst=conn.prepareStatement(sql);
		System.out.println("Sql������ɹ�");
		
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
