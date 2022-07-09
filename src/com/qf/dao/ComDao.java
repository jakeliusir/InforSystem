package com.qf.dao;

import java.sql.*;
import java.util.*;

public class ComDao {

	private DBHelper db = null;

	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id  ,brand,price,color from computer");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
			
				// 把这一行数据整体装载到list中
				list.add(map);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 查询一个车牌的信息
	public Map queryOne(String id1) {
		// 最终返回一行数据

		Map map = new HashMap();
		try {
			// 根据 id 单独的查询一个学生
			db = new DBHelper("select   id  ,brand,price,color  from computer where id=?");
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

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
			
				// 把这一行数据整体装载到list中

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// 添加的方法
	public boolean addComputer(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "insert into computer(brand,price,color) values(?,?,?)";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("brand"));
			db.pst.setObject(2, map.get("price"));
			db.pst.setObject(3, map.get("color"));
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
	public boolean UpdateComputer(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "update  computer  set  brand=?,price=?,color=? where id=?";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("brand"));
			db.pst.setObject(2, map.get("price"));
			db.pst.setObject(3, map.get("color"));
			db.pst.setObject(4, map.get("id"));
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

	public boolean DeleteComputer(String id) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "delete  from computer  where id=?";
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
	public List<Map> queryComByName(String combrand) {
		List<Map> list = new ArrayList();

		try {
			//%属于特殊字符，与占位符放在一起会出现问题
			db = new DBHelper("select   id  ,brand,price,color from computer where brand like '%"+combrand+"%'");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

				

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
				
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
		ComDao stu = new ComDao();
		// List<Map> list = stu.queryAll();
		// System.out.println(list);
		// Map map=stu.queryOne("10");
		// System.out.println(map);
		Map map = new HashMap();
		map.put("name", "佳恩李");
		map.put("sex", "女");
		map.put("address", "地球");
		map.put("id", "27");
		// 测试添加的方法
		// boolean flag=stu.addStudent(map);
		// 测试修改
		// boolean flag = stu.UpdateStudent(map);
		// 测试删除的方法
         //boolean flag =stu.DeleteStudent("27");
		
		System.out.println(stu.queryComByName("惠"));
	}

}
