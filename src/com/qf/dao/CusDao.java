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
			db = new DBHelper("select   id  ,�˿�,�Ӵ���,����Ʒ��,�۸�  from customer");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String �˿� = rs.getString("�˿�");

				String �Ӵ��� = rs.getString("�Ӵ���");

				String ����Ʒ�� = rs.getString("����Ʒ��");
				
				String �۸� = rs.getString("�۸�");

			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("�˿�", �˿�);
				map.put("�Ӵ���", �Ӵ���);
				map.put("����Ʒ��", ����Ʒ��);
				map.put("�۸�", �۸�);
			
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
			db = new DBHelper("select   id  ,�˿�,�˿�,�Ӵ���,����Ʒ��,�۸�  from  customer where id=?");
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

				String �˿� = rs.getString("�˿�");

				String �Ӵ��� = rs.getString("�Ӵ���");

				String ����Ʒ�� = rs.getString("����Ʒ��");
				
				String �۸� = rs.getString("�۸�");
			

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("�˿�", �˿�);
				map.put("�Ӵ���", �Ӵ���);
				map.put("����Ʒ��", ����Ʒ��);
				map.put("�۸�", �۸�);
				// ����һ����������װ�ص�list��

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public boolean addCustomer(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "insert into customer(�˿�,�Ӵ���,����Ʒ��,�۸�) values(?,?,?,?)";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("�˿�"));
			db.pst.setObject(2, map.get("�Ӵ���"));
			db.pst.setObject(3, map.get("����Ʒ��"));
			db.pst.setObject(4, map.get("�۸�"));
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
    
	public boolean UpdateCustomer(Map map) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "update  customer set  �˿�=?,�Ӵ���=?,����Ʒ��=?,�۸�=? where id=?";
		try {
			db = new DBHelper(sql);
			// ��ռλ�����滻��������ֵ
			db.pst.setObject(1, map.get("�˿�"));
			db.pst.setObject(2, map.get("�Ӵ���"));
			db.pst.setObject(3, map.get("����Ʒ��"));
			db.pst.setObject(4, map.get("�۸�"));
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
	
	public boolean DeleteCustomer(String id) {
		// ���������ռλ�� ������Ҫ���ʺ��滻�������ֵ
		String sql = "delete  from customer  where id=?";
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
	
	public List<Map> queryCusByName(String cus) {
		List<Map> list = new ArrayList();

		try {
			//%���������ַ�����ռλ������һ����������
			db = new DBHelper("select   id  ,�˿�,�Ӵ���,����Ʒ��,�۸�  from customer where �˿� like '%"+cus+"%'");
			// ��ѯһ�����ݷŵ����������
			ResultSet rs = db.pst.executeQuery();
			// �ӽ������ ͨ��whileѭ������ȡ��ÿһ�о�
			// rs.next() �ж���һ�� ��û������ �����ݷ���true �����ݷ��� false
			while (rs.next()) {
				// ��ȡ����ÿһ��������һ��map
				Map map = new HashMap();
				// ����ȡ��ÿһ�е�ÿһ������ݣ��ŵ�Map��
				String id = rs.getString("id");

				String �˿� = rs.getString("�˿�");

				String �Ӵ��� = rs.getString("�Ӵ���");

				String ����Ʒ�� = rs.getString("����Ʒ��");

				String �۸� = rs.getString("�۸�");

				// ÿһ������װ�ص�Map��
				map.put("id", id);
				map.put("�˿�", �˿�);
				map.put("�Ӵ���", �Ӵ���);
				map.put("����Ʒ��", ����Ʒ��);
				map.put("�۸�", �۸�);
				
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
	
	}
}
