package com.example.first.demo.Service;
import java.util.List;


import com.example.first.demo.Entity.Login;

public interface loginService {

	public List<Login> getlogin();

	public Login getlogin(long courseId);

	public Login addlogin(Login course);
	
	public Login updatelogin(Login course);
	
	public void deletelogin(long parseLong);


}
