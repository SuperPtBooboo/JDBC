package com.jw.test;

import org.junit.Test;

import com.jw.entity.Teacher;
import com.jw.imp.TeacherImp;


public class TeacherTest {

	@Test
	public void tt(){
		Teacher t = new Teacher(102, "张小男", "女", 44, "湖上");
		new TeacherImp().selectAll();
	}
}
