package com.jw.dao;

import com.jw.entity.Teacher;

public interface Dao {
	void addTeacher(Teacher t);
	void deleteTeacher(int id);
	void updateTeacher(Teacher t);
	void selectAll();
}
