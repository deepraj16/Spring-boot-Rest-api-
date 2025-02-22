package com.demo.firstSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.firstSpring.Entity.Course;

public interface CourseDao extends JpaRepository<Course , Long>{

}
