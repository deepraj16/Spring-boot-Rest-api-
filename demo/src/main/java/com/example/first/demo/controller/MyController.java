package com.example.first.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.first.demo.Entity.Login;
import com.example.first.demo.Service.loginService;

import com.example.first.demo.dao.LoginDao;


import com.example.first.demo.Service.movieService;
import com.example.first.demo.Entity.Movie;
import com.example.first.demo.dao.MovieDao;



@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin("http://localhost:4200/")
public class MyController {
	

	@Autowired
	private loginService ls; 
	@Autowired
	private movieService ms;

	@GetMapping("/")
	public String home() {
		return "Welcome to course application";
	}
	@GetMapping("/login")
	public List<Login> getlogin(){
		return this.ls.getlogin();
		
	}
	

	@GetMapping("/login/{loginid}")
	public Login getlogin(@PathVariable String loginid) {
		return this.ls.getlogin(Long.parseLong(loginid));
	}
	
	@PostMapping("/login")
	public Login addlogin(@RequestBody Login course) {
		return this.ls.addlogin(course);
		
	}
	 private final List<Login> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody Login user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password are required!");
        }
        users.add(user);
        return ResponseEntity.ok("User added successfully");
    }

	@PutMapping("/login")
	public Login updatelogin(@RequestBody Login course) {
		return this.ls.updatelogin(course);
	}
	
	@DeleteMapping("/login/{login}")
	public ResponseEntity<HttpStatus> deletelogin
	(@PathVariable String courseId) {
		try {
			this.ls.deletelogin(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>
			(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
		
		@GetMapping("/movie")
		public List<Movie> getmovie(){
			return this.ms.getmovie();
		}
		

		@GetMapping("/movie/{loginid}")
		public Movie getmovie(@PathVariable String loginid) {
			return this.ms.getmovie(Long.parseLong(loginid));
		}
		
		@PostMapping("/movie")
		public Movie addmovie(@RequestBody Movie course) {
			return this.ms.addmovie(course);
			
		}
		
		@PutMapping("/movie")
		public Movie updatemovie(@RequestBody Movie course) {
			return this.ms.updatemovie(course);
		}

		@DeleteMapping("/movie/{login}")
	public ResponseEntity<HttpStatus> deletemovie
	(@PathVariable String courseId) {
		try {
			this.ms.deletemovie(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>
			(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
	}
}


