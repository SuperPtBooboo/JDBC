package com.jw.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jw.dataUtil.DataUtil;
import com.jw.entity.Teacher;
import com.jw.imp.TeacherImp;


public class TeacherTest {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Test
	public void to(){
		TeacherImp ti = new TeacherImp();
		ti.addTeacher(new Teacher(52, "糖果", "女",47, "山的那边"));
		ti.addTeacher(new Teacher(14, "水果", "女",47, "树边"));
		ti.addTeacher(new Teacher(562, "饭堂", "女",7, "球场边"));
	}

	@Test
	public void tt(){
		con=DataUtil.getConnection();
		try {
			//将事务挂起
			con.setAutoCommit(false);			
			ps=con.prepareStatement("delete from teacher where tid=?");
			ps.setInt(1, 14);
			ps.execute();
			ps=con.prepareStatement("select * from ttttt");
			ps.execute();
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//回滚
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			
			DataUtil.closeCon(con, ps, rs);
		}
	}
}
