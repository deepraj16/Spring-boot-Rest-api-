package com.example.first.demo.Service;
import com.example.first.demo.dao.LoginDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.demo.Entity.Login;

@Service
public  class loginServiceIMPL implements loginService {

	@Autowired
	private LoginDao courseDao;
	

	public List<Login> getlogin() {
				return courseDao.findAll();
	}
	
	public Login getlogin(long courseId) {
		
		return courseDao.findById(courseId).get();
	}

	public Login addlogin(Login course) {
	      courseDao.save(course);
		return course;
	}
	
	public Login updatelogin(Login course) {
	courseDao.save(course);
		return course;
	}

	public void deletelogin(long parseLong) {
		Login entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}

