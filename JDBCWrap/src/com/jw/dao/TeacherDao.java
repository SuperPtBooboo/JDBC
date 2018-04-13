package com.jw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jw.DateUtil.DateUtil;
import com.jw.entity.Teacher;

public class TeacherDao implements Dao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void addTeacher(Teacher t) {		
		try {
			con=DateUtil.conn();
			String str = "insert into teacher(tname,sex,age,address) values(?,?,?,?)";
			ps=con.prepareStatement(str);
			ps.setString(1, t.getTname());
			ps.setString(2, Character.toString(t.getSex()));
			ps.setInt(3, t.getAge());
			ps.setString(4, t.getAddress());
			ps.execute();
			//返回对象的tid值
			String str2 = "select * from teacher where tname=?";
			ps=con.prepareStatement(str2);
			ps.setString(1, t.getTname());
			rs=ps.executeQuery();
			if(rs.next()){
				t.setTid(rs.getInt("tid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void deleteTeacher(String name) {
		try {
			con=DateUtil.conn();
			String str = "delete from teacher where tname=?";
			ps=con.prepareStatement(str);
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public void updateTeacher(Teacher t) {
		try {
			con=DateUtil.conn();
			String str = "update teacher set tname=?,sex=?,age=?,address=? where tid=?";
			ps=con.prepareStatement(str);
			ps.setString(1, t.getTname());
			ps.setString(2, Character.toString(t.getSex()));
			ps.setInt(3, t.getAge());
			ps.setString(4, t.getAddress());
			ps.setInt(5, t.getTid());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
	}
	@Override
	public List<Teacher> selectTeacher() {
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			con=DateUtil.conn();
			String str = "select * from teacher";
			ps=con.prepareStatement(str);
			rs=ps.executeQuery();
			while(rs.next()){
				Teacher t = new Teacher();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				t.setSex(rs.getString("sex").toCharArray()[0]);
				t.setAge(rs.getInt("age"));
				t.setAddress(rs.getString("address"));
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	


}
