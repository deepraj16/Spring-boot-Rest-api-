package com.demo.firstSpring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	private long id; 
	private String title; 
	private String descriptions; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Course(long id, String title, String descriptions) {
		super();
		this.id = id;
		this.title = title;
		this.descriptions = descriptions;
	}

	public Course() {
		super(); 
		
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", descriptions=" + descriptions + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getDescriptions()=" + getDescriptions() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
