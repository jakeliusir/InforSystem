package com.qf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CusDao {
	private DBHelper db = null;

	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id  ,顾客,接待人,电脑品牌,价格  from customer");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String 顾客 = rs.getString("顾客");

				String 接待人 = rs.getString("接待人");

				String 电脑品牌 = rs.getString("电脑品牌");
				
				String 价格 = rs.getString("价格");

			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("顾客", 顾客);
				map.put("接待人", 接待人);
				map.put("电脑品牌", 电脑品牌);
				map.put("价格", 价格);
			
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
			db = new DBHelper("select   id  ,顾客,顾客,接待人,电脑品牌,价格  from  customer where id=?");
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

				String 顾客 = rs.getString("顾客");

				String 接待人 = rs.getString("接待人");

				String 电脑品牌 = rs.getString("电脑品牌");
				
				String 价格 = rs.getString("价格");
			

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("顾客", 顾客);
				map.put("接待人", 接待人);
				map.put("电脑品牌", 电脑品牌);
				map.put("价格", 价格);
				// 把这一行数据整体装载到list中

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public boolean addCustomer(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "insert into customer(顾客,接待人,电脑品牌,价格) values(?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("顾客"));
			db.pst.setObject(2, map.get("接待人"));
			db.pst.setObject(3, map.get("电脑品牌"));
			db.pst.setObject(4, map.get("价格"));
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
    
	public boolean UpdateCustomer(Map map) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "update  customer set  顾客=?,接待人=?,电脑品牌=?,价格=? where id=?";
		try {
			db = new DBHelper(sql);
			// 把占位符？替换成真正的值
			db.pst.setObject(1, map.get("顾客"));
			db.pst.setObject(2, map.get("接待人"));
			db.pst.setObject(3, map.get("电脑品牌"));
			db.pst.setObject(4, map.get("价格"));
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
	
	public boolean DeleteCustomer(String id) {
		// ？代表的是占位符 最终需要把问号替换成真真的值
		String sql = "delete  from customer  where id=?";
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
	
	public List<Map> queryCusByName(String cus) {
		List<Map> list = new ArrayList();

		try {
			//%属于特殊字符，与占位符放在一起会出现问题
			db = new DBHelper("select   id  ,顾客,接待人,电脑品牌,价格  from customer where 顾客 like '%"+cus+"%'");
			// 查询一个数据放到结果集合中
			ResultSet rs = db.pst.executeQuery();
			// 从结果集中 通过while循环挨个取出每一行据
			// rs.next() 判断下一行 有没有数据 有数据返回true 无数据返回 false
			while (rs.next()) {
				// 给取出的每一行数据造一个map
				Map map = new HashMap();
				// 单独取出每一行的每一类的数据，放到Map中
				String id = rs.getString("id");

				String 顾客 = rs.getString("顾客");

				String 接待人 = rs.getString("接待人");

				String 电脑品牌 = rs.getString("电脑品牌");

				String 价格 = rs.getString("价格");

				// 每一列数据装载到Map中
				map.put("id", id);
				map.put("顾客", 顾客);
				map.put("接待人", 接待人);
				map.put("电脑品牌", 电脑品牌);
				map.put("价格", 价格);
				
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
	
	}
}
