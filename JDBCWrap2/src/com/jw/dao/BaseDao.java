package com.jw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jw.dataUtil.DataUtil;

public class BaseDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	protected void updateMethod(String sql,Object[] objs){
		con=DataUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for(int i=0;i<objs.length;i++){
					ps.setObject(i+1, objs[i]);
				}
			}
			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
