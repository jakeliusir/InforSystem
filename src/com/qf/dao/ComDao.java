package com.qf.dao;

import java.sql.*;
import java.util.*;

public class ComDao {

	private DBHelper db = null;

	public List<Map> queryAll() {
		List<Map> list = new ArrayList();

		try {
			db = new DBHelper("select   id  ,brand,price,color from computer");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
			
				// ����һ����������װ�ص�list��
				list.add(map);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// ��ѯһ�����Ƶ���Ϣ
	public Map queryOne(String id1) {
		// ���շ���һ������

		Map map = new HashMap();
		try {
			// ���� id �����Ĳ�ѯһ��ѧ��
			db = new DBHelper("select   id  ,brand,price,color  from computer where id=?");
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

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
			
				// ����һ����������װ�ص�list��

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// ��ӵķ���
	public boolean addComputer(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "insert into computer(brand,price,color) values(?,?,?)";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("brand"));
			db.pst.setObject(2, map.get("price"));
			db.pst.setObject(3, map.get("color"));
			// ��ʼִ����ӵķ���
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

	// ���ݵ��޸�
	public boolean UpdateComputer(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "update  computer  set  brand=?,price=?,color=? where id=?";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("brand"));
			db.pst.setObject(2, map.get("price"));
			db.pst.setObject(3, map.get("color"));
			db.pst.setObject(4, map.get("id"));
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

	public boolean DeleteComputer(String id) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "delete  from computer  where id=?";
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
	public List<Map> queryComByName(String combrand) {
		List<Map> list = new ArrayList();

		try {
			//%���������ַ�����ռλ������һ����������
			db = new DBHelper("select   id  ,brand,price,color from computer where brand like '%"+combrand+"%'");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String brand = rs.getString("brand");

				String price = rs.getString("price");

				String color = rs.getString("color");

				

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("brand", brand);
				map.put("price", price);
				map.put("color", color);
				
				// ����һ����������װ�ص�list��
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
		map.put("name", "�Ѷ���");
		map.put("sex", "Ů");
		map.put("address", "����");
		map.put("id", "27");
		// ������ӵķ���
		// boolean flag=stu.addStudent(map);
		// �����޸�
		// boolean flag = stu.UpdateStudent(map);
		// ����ɾ���ķ���
         //boolean flag =stu.DeleteStudent("27");
		
		System.out.println(stu.queryComByName("��"));
	}

}
