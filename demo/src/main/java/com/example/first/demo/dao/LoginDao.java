package com.example.first.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.demo.Entity.Login;

public interface LoginDao extends JpaRepository<Login , Long>{

}
