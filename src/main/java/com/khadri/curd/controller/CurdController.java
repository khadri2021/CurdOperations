package com.khadri.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khadri.curd.dao.CurdDao;
import com.khadri.curd.entity.Student;

@RestController("/")
public class CurdController {

	@Autowired
	CurdDao curdDao;
	
	
	@GetMapping(value = "studentinfo")
	public ResponseEntity<Student> getStudentDetails(@RequestParam  String UUID) {
		
		Student studentInfo = curdDao.getStudent(UUID);	
		
		return ResponseEntity.ok(studentInfo);
	}
	
	
	@PostMapping(value = "studentinfo")
	public ResponseEntity<String> postStudentDetails(@RequestBody Student student){
		
		String UUID = curdDao.insertStudent(student);
		
		ResponseEntity<String> entity= new ResponseEntity<>(UUID, HttpStatus.CREATED);
		
		return entity;
	}
	
	
	@PutMapping(value = "studentinfo")
	public ResponseEntity<String> putStudentDetails(@RequestBody Student student){
		
		  curdDao.updateOrReplaceStudent(student);
		
		ResponseEntity<String> entity= new ResponseEntity<>("Updated/Replace Successfuly!!!",HttpStatus.OK);
		
		return entity;
	}
	
	
	@PatchMapping(value = "studentinfo")
	public ResponseEntity<String> patchStudentDetails(@RequestBody Student student){
		
		  curdDao.updateStudent(student);
		
		ResponseEntity<String> entity= new ResponseEntity<>("Updated Successfuly!!!",HttpStatus.OK);
		
		return entity;
	}
	
	
	@DeleteMapping(value = "studentinfo/{UUID}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable String UUID){
		
		  curdDao.deleteStudent(UUID);
		
		ResponseEntity<String> entity= new ResponseEntity<>("Deleted Successfuly!!!",HttpStatus.NO_CONTENT);
		
		return entity;
	}
	
}
