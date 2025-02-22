
package com.example.first.demo.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.demo.Entity.Movie;
import com.example.first.demo.dao.MovieDao;

@Service
public  class movieServiceIMPL implements movieService {

	@Autowired
	private MovieDao courseDao;

	@Override
	public List<Movie> getmovie() {
				return courseDao.findAll();
	}
	
	public Movie getmovie(long courseId) {
		
		return courseDao.findById(courseId).get();
	}
	public Movie addmovie(Movie course) {
	      courseDao.save(course);
		return course;
	}
	public Movie updatemovie(Movie course) {
	courseDao.save(course);
		return course;
	}
	public void deletemovie(long parseLong) {
		Movie entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
	
	
	

}

