package com.jw.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.jw.dao.TeacherDao;
import com.jw.entity.Teacher;


public class TeacharTest {
	@Test
	public void test(){
//		TeacherDao td = new TeacherDao();
//		td.addTeacher(new Teacher("李白", '男', 56, "中国不详"));
//		td.addTeacher(new Teacher("小二", '男', 15, "中国贵州"));
//		td.addTeacher(new Teacher("胖大海", '女', 45, "合肥"));
//		td.addTeacher(new Teacher("花姑娘", '女', 24, "四川成都"));
//		td.addTeacher(new Teacher("王八", '男', 46, "黑河"));
//		td.addTeacher(new Teacher("太阳", '男', 555, "银河系"));
//		td.deleteTeacher("李白");
//		td.updateTeacher(new Teacher(1,"李白", '女', 56, "反正不是韩国"));
		
		List<Teacher> tlist=new TeacherDao().selectTeacher();
		Iterator<Teacher> it = tlist.iterator();
		while(it.hasNext()){
			Teacher t = it.next();
			System.out.println(t);
		}
		System.out.println(tlist.size());
		Teacher temp = tlist.get(2);
		System.out.println(temp);
		temp.setTname("爱而不得");
		new TeacherDao().updateTeacher(temp);
		
	}
}
