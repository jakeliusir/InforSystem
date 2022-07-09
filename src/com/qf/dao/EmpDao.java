package com.qf.dao;

import java.sql.*;
import java.util.*;

public class EmpDao {

	private DBHelper db = null;

	
	// 查询一个员工的信息
	public Map login(String username) {
		// 最终返回一行数据

		Map map = new HashMap();
		try {
			// 根据 id 单独的查询一个员工
			db = new DBHelper("select   id  ,username,password,qx  from  employee where username=? ");
			// 用真正的参数 替换 占位符？

			db.pst.setString(1, username);

			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map

				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String uname = rs.getString("username");

				String password = rs.getString("password");

				String qx = rs.getString("qx");
				

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("username", uname);
				map.put("password", password);
				map.put("qx", qx);
			
				// 把这一行数据整体装载到list中

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	
	
	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id  ,username,password,phone,section from employee");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
			
				// 把这一行数据整体装载到list中
				list.add(map);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Map queryOne(String id1) {
		// 最终返回一行数据

		Map map = new HashMap();
		try {
			// 根据 id 单独的查询一个学生
			db = new DBHelper("select   id  ,username,password,phone,section  from employee where id=?");
			// 用真正的参数 替换 占位符？

			db.pst.setString(1, id1);

			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map

				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

			    

				// 每一列数据装载到Map中
				
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
				// 把这一行数据整体装载到list中

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// 添加的方法
	public boolean addEmployee(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "insert into employee(username,password,qx,phone,section) values(?,?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("username"));
			db.pst.setObject(2, map.get("password"));
			db.pst.setObject(3, map.get("qx"));
			db.pst.setObject(4, map.get("phone"));
			db.pst.setObject(5, map.get("section"));
			// 开始执行添加的方法
			int value = db.pst.executeUpdate();
			if (value > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// 数据的修改
	public boolean UpdateEmployee(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "update  employee  set  username=?,password=?,phone=?,section=? where id=?";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("username"));
			db.pst.setObject(2, map.get("password"));
			db.pst.setObject(3, map.get("phone"));
			db.pst.setObject(4, map.get("section"));
			db.pst.setObject(5, map.get("id"));
			// 开始执行添加的方法
			int value = db.pst.executeUpdate();
			if (value > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return false;
	}
	// 信息删除的方法

	public boolean DeleteEmployee(String id) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "delete  from employee  where id=?";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值

			db.pst.setObject(1, id);
			// 开始执行添加的方法
			int value = db.pst.executeUpdate();
			if (value > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return false;
	}
	
	//模糊查询，根据姓名中的某一部分进行查询
	//根据学生姓名进行查询
	public List<Map> queryEmpByName(String value) {
		List<Map> list = new ArrayList();

		try {
			//%属于特殊字符，与占位符放在一起会出现问题
			db = new DBHelper("select   id  ,username,password,phone,section from employee where username like '%"+value+"%'");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

				

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
				// 把这一行数据整体装载到list中
				list.add(map);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDao myuser = new EmpDao();
		Map map=myuser.login("admin");
		System.out.println(map);
	
		
	}

}
