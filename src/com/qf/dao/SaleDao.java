package com.qf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleDao {
	private DBHelper db = null;	
	// ��ѯһ���������۵���
	
	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id, computer_name, sales, price, date, sale_name from sale");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");
				String date = rs.getString("date");
				String sale_name = rs.getString("sale_name");

			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("computer_name", computer_name);
				map.put("sales", sales);
				map.put("price", price);
				map.put("date", date);
				map.put("sale_name", sale_name);
			
				// ����һ����������װ�ص�list��
				list.add(map);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Map queryOne(String id1) {
		// ���շ���һ������

		Map map = new HashMap();
		try {
			// ���� id �����Ĳ�ѯһ��ѧ��
			db = new DBHelper("select   id, computer_name, sales, price, date, sale_name  from sale where id=?");
			// �������Ĳ��� �滻 ռλ����

			db.pst.setString(1, id1);

			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map

				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");
				
				String date = rs.getString("date");
				String sale_name = rs.getString("sale_name");

			    

				// ÿһ������װ�ص�Map��
				
				map.put("id", id);
				map.put("computer_name", computer_name);
				map.put("sales", sales);
				map.put("price", price);
				map.put("date", date);
				map.put("sale_name", sale_name);
				// ����һ����������װ�ص�list��

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// ��ӵķ���
	public boolean addSale(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "insert into sale(computer_name,sales,price,date,sale_name) values(?,?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("computer_name"));
			db.pst.setObject(2, map.get("sales"));
			db.pst.setObject(3, map.get("price"));
			db.pst.setObject(4, map.get("date"));
			db.pst.setObject(5, map.get("sale_name"));
			// ��ʼִ����ӵķ���
			int value = db.pst.executeUpdate();
			System.out.print("��ӳɹ�");
			if (value > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// ���ݵ��޸�
	public boolean UpdateSale(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "update  sale  set  computer_name=?,sales=?,price=?,date=?,sale_name=? where id=?";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("computer_name"));
			db.pst.setObject(2, map.get("sales"));
			db.pst.setObject(3, map.get("price"));
			db.pst.setObject(4, map.get("date"));
			db.pst.setObject(5, map.get("sale_name"));
			db.pst.setObject(6, map.get("id"));
			// ��ʼִ����ӵķ���
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
	// ��Ϣɾ���ķ���

	public boolean DeleteSale(String id) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "delete  from sale  where id=?";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ

			db.pst.setObject(1, id);
			// ��ʼִ����ӵķ���
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
	
	//ģ����ѯ�����������е�ĳһ���ֽ��в�ѯ
	//����ѧ���������в�ѯ
	public List<Map> querySaleByName(String stuName) {
		List<Map> list1 = new ArrayList();

		try {
			//%���������ַ�����ռλ������һ����������
			db = new DBHelper("select   id ,computer_name,sales,price,sale_name,date  from sale where computer_name like '%"+stuName+"%'");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			System.out.print("��ѯģ���ɹ� sale");
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map1 = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String computer_name = rs.getString("computer_name");

				String sales = rs.getString("sales");

				String price = rs.getString("price");

				String sale_name = rs.getString("sale_name");
				String date = rs.getString("date");

				

				// ÿһ������װ�ص�Map��
				map1.put("id", id);
				map1.put("computer_name", computer_name);
				map1.put("sales", sales);
				map1.put("price", price);
				map1.put("sale_name", sale_name);
				map1.put("date", date);
				// TODO Auto-generated method stub
				System.out.println("���뵽��̨��sale1");
				// ����һ����������װ�ص�list��
				list1.add(map1);
				// TODO Auto-generated method stub
				System.out.println("���뵽��̨sale2");

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
