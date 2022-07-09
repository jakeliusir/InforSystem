package com.qf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleDao {
	private DBHelper db = null;	
	// 查询一个电脑销售的信
	
	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id, computer_name, sales, price, date, sale_name from sale");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");
				String date = rs.getString("date");
				String sale_name = rs.getString("sale_name");

			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("computer_name", computer_name);
				map.put("sales", sales);
				map.put("price", price);
				map.put("date", date);
				map.put("sale_name", sale_name);
			
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
			db = new DBHelper("select   id, computer_name, sales, price, date, sale_name  from sale where id=?");
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

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");
				
				String date = rs.getString("date");
				String sale_name = rs.getString("sale_name");

			    

				// 每一列数据装载到Map中
				
				map.put("id", id);
				map.put("computer_name", computer_name);
				map.put("sales", sales);
				map.put("price", price);
				map.put("date", date);
				map.put("sale_name", sale_name);
				// 把这一行数据整体装载到list中

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// 添加的方法
	public boolean addSale(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "insert into sale(computer_name,sales,price,date,sale_name) values(?,?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("computer_name"));
			db.pst.setObject(2, map.get("sales"));
			db.pst.setObject(3, map.get("price"));
			db.pst.setObject(4, map.get("date"));
			db.pst.setObject(5, map.get("sale_name"));
			// 开始执行添加的方法
			int value = db.pst.executeUpdate();
			System.out.print("添加成功");
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
	public boolean UpdateSale(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "update  sale  set  computer_name=?,sales=?,price=?,date=?,sale_name=? where id=?";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("computer_name"));
			db.pst.setObject(2, map.get("sales"));
			db.pst.setObject(3, map.get("price"));
			db.pst.setObject(4, map.get("date"));
			db.pst.setObject(5, map.get("sale_name"));
			db.pst.setObject(6, map.get("id"));
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

	public boolean DeleteSale(String id) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "delete  from sale  where id=?";
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
	public List<Map> querySaleByName(String stuName) {
		List<Map> list1 = new ArrayList();

		try {
			//%属于特殊字符，与占位符放在一起会出现问题
			db = new DBHelper("select   id ,computer_name,sales,price,sale_name,date  from sale where computer_name like '%"+stuName+"%'");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			System.out.print("查询模糊成功 sale");
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map1 = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");

				String sale_name = rs.getString("sale_name");
				String date = rs.getString("date");

				

				// 每一列数据装载到Map中
				map1.put("id", id);
				map1.put("computer_name", computer_name);
				map1.put("sales", sales);
				map1.put("price", price);
				map1.put("sale_name", sale_name);
				map1.put("date", date);
				// TODO Auto-generated method stub
				System.out.println("进入到后台了sale1");
				// 把这一行数据整体装载到list中
				list1.add(map1);
				// TODO Auto-generated method stub
				System.out.println("进入到后台sale2");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	}

}
