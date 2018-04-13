package com.jw.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jw.dao.BaseDao;
import com.jw.dao.Dao;
import com.jw.dataUtil.DataUtil;
import com.jw.entity.Teacher;
import com.mysql.fabric.xmlrpc.base.Array;

public class TeacherImp extends BaseDao implements Dao {

	@Override
	public void addTeacher(Teacher t) {
		// TODO Auto-generated method stub
		String str = "insert into teacher(tid,tname,sex,age,address) values(?,?,?,?,?)";
		Object[] obj={t.getTid(),t.getName(),t.getSex(),t.getAge(),t.getAddress()};
		updateMethod(str, obj);
	}

	@Override
	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		String str = "delete from teacher where tid=?";
		Object[] obj={id};
		updateMethod(str, obj);
	}

	@Override
	public void updateTeacher(Teacher t) {
		// TODO Auto-generated method stub
		String str = "update teacher set tname=?,sex=?,age=?,address=? where tid=?";
		Object[] obj={t.getName(),t.getSex(),t.getAge(),t.getAddress(),t.getTid()};
		updateMethod(str, obj);
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		Connection con=DataUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from teacher");
			ResultSet rs = ps.executeQuery();
			List<Teacher> tlist = new ArrayList<Teacher>();
			while(rs.next()){
				Teacher t = new Teacher();
				t.setTid(rs.getInt("tid"));
				t.setName(rs.getString("tname"));
				t.setSex(rs.getString("sex"));
				t.setAge(rs.getInt("age"));
				t.setAddress(rs.getString("address"));
				tlist.add(t);
			}
			
			Iterator<Teacher> it = tlist.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
