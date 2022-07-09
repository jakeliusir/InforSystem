package com.qf.dao;

import java.sql.*;
import java.util.*;

public class EmpDao {

	private DBHelper db = null;

	
	// ��ѯһ��Ա������Ϣ
	public Map login(String username) {
		// ���շ���һ������

		Map map = new HashMap();
		try {
			// ���� id �����Ĳ�ѯһ��Ա��
			db = new DBHelper("select   id  ,username,password,qx  from  employee where username=? ");
			// �������Ĳ��� �滻 ռλ����

			db.pst.setString(1, username);

			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map

				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String uname = rs.getString("username");

				String password = rs.getString("password");

				String qx = rs.getString("qx");
				

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("username", uname);
				map.put("password", password);
				map.put("qx", qx);
			
				// ����һ����������װ�ص�list��

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
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
			
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
			db = new DBHelper("select   id  ,username,password,phone,section  from employee where id=?");
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

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

			    

				// ÿһ������װ�ص�Map��
				
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
				// ����һ����������װ�ص�list��

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// ��ӵķ���
	public boolean addEmployee(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "insert into employee(username,password,qx,phone,section) values(?,?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("username"));
			db.pst.setObject(2, map.get("password"));
			db.pst.setObject(3, map.get("qx"));
			db.pst.setObject(4, map.get("phone"));
			db.pst.setObject(5, map.get("section"));
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
	public boolean UpdateEmployee(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "update  employee  set  username=?,password=?,phone=?,section=? where id=?";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("username"));
			db.pst.setObject(2, map.get("password"));
			db.pst.setObject(3, map.get("phone"));
			db.pst.setObject(4, map.get("section"));
			db.pst.setObject(5, map.get("id"));
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

	public boolean DeleteEmployee(String id) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "delete  from employee  where id=?";
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
	public List<Map> queryEmpByName(String value) {
		List<Map> list = new ArrayList();

		try {
			//%���������ַ�����ռλ������һ����������
			db = new DBHelper("select   id  ,username,password,phone,section from employee where username like '%"+value+"%'");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String username = rs.getString("username");

				String password = rs.getString("password");

				String phone = rs.getString("phone");
				String section = rs.getString("section");

				

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("username", username);
				map.put("password", password);
				map.put("phone", phone);
				map.put("section", section);
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
		EmpDao myuser = new EmpDao();
		Map map=myuser.login("admin");
		System.out.println(map);
	
		
	}

}
