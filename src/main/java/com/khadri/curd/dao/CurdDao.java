package com.khadri.curd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khadri.curd.entity.Student;

@Repository
public class CurdDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	
	public Student getStudent(String uuid) {
		 
		Session session = sessionFactory.openSession();
		
		Student std = session.get(Student.class, uuid);
		
		
		return std;
		
	}
}
