package com.example.first.demo.Service;
import java.util.List;

import com.example.first.demo.Entity.Movie;

public interface movieService {

	public List<Movie> getmovie();
	
	public Movie getmovie(long courseId);
	public Movie addmovie(Movie course);
	public Movie updatemovie(Movie course);
	public void deletemovie(long parseLong);
}
