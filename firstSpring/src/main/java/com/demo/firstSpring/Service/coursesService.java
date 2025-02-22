package com.demo.firstSpring.Service;

import java.util.List;

import com.demo.firstSpring.Entity.Course;

public interface coursesService {
public List<Course> getCourses();
	
	public Course getCourse(long courseId);

	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);

}
