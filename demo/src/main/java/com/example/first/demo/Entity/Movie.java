package com.example.first.demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	private long id;
	private String moviename;
	private String related_date ;
	private String show_time ;
	private String desc1 ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getRelated_date() {
		return related_date;
	}

	public void setRelated_date(String related_date) {
		this.related_date = related_date;
	}

	public String getShow_time() {
		return show_time;
	}

	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}

	public String getDesc() {
		return desc1;
	}

	public void setDesc(String desc) {
		this.desc1 = desc;
	}

	public Movie(long id, String moviename, String related_date,String show_time,String desc) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.related_date = related_date;
		this.show_time=show_time;
		this.desc1=desc;
	}

	public Movie() {
		super();
		
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", moviename=" + moviename + ", related_date=" + related_date + ", show_time="
				+ show_time + ", desc=" + desc1 + ", getId()=" + getId()+", getMoviename"+ getMoviename() +", getRelated_date"+getRelated_date()+"getShow_time"+getShow_time() +", getDesc"+getDesc()+", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
