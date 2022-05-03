package com.khadri.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khadri.curd.dao.CurdDao;
import com.khadri.curd.entity.Student;

@RestController("/")
public class CurdController {

	@Autowired
	CurdDao curdDao;
	
	
	@RequestMapping(value = "studentinfo",method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentDetails(@RequestParam  String UUID) {
		
		Student studentInfo = curdDao.getStudent(UUID);	
		
		return ResponseEntity.ok(studentInfo);
	}
	
}
