package com.demo.firstSpring.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.firstSpring.Entity.Course;
import com.demo.firstSpring.dao.CourseDao;

@Service
public class courseServiceIMPL implements coursesService {

	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	public List<Course> getCourses() {
				return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		
		return courseDao.findById(courseId).get();
	}
	@Override
	public Course addCourse(Course course) {
	      courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
	courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}

