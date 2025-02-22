
package com.example.first.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.demo.Entity.Movie;

public interface MovieDao extends JpaRepository<Movie , Long>{

}
