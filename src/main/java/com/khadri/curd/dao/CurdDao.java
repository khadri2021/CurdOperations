package com.khadri.curd.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	
	public String insertStudent(Student student) {
		 
		  Session session = sessionFactory.openSession();
		  Transaction txn = session.beginTransaction();
		  	
		 String uuid = (String) session.save(student);
		  
		  txn.commit();
	 
		return uuid;
		
	}
	
	public void updateOrReplaceStudent(Student student) {
		 
		  Session session = sessionFactory.openSession();
		  Transaction txn = session.beginTransaction();
		  	
		  session.merge(student);
		  
		  txn.commit();
	 
	}
	
	
	public void updateStudent(Student student) {
		 
		  Session session = sessionFactory.openSession();
		  Transaction txn = session.beginTransaction();
		  	
		  session.update(student);
		  
		  txn.commit();
	 
	}
	
	
	public void deleteStudent(String uuid) {
		 
		  Session session = sessionFactory.openSession();
		  Transaction txn = session.beginTransaction();
		  	
		  Student student = session.get(Student.class, uuid);
		  
		  if(Objects.nonNull(student))
			  	session.delete(student);
		  
		  txn.commit();
	 
	}
}
