package com.jw.dao;

import java.util.List;

import com.jw.entity.Teacher;

public interface Dao {
	void addTeacher(Teacher t);
	void deleteTeacher(String name);
	void updateTeacher(Teacher t);
	List<Teacher> selectTeacher();
}
