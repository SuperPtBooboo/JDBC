package com.jw.test;

import org.junit.Test;

import com.jw.dataUtil.DataUtil;
import com.jw.entity.Teacher;
import com.jw.imp.TeacherImp;


public class TeacherTest {

	@Test
	public void tt(){
		TeacherImp ti = new TeacherImp();
		Teacher t = new Teacher(114, "天蓬元帅", "男", 120, "广寒宫");
		ti.addTeacher(t);
		ti.deleteTeacher(102);
		ti.selectAll();
		
//		System.out.println(DataUtil.getConnection());
	}
}
