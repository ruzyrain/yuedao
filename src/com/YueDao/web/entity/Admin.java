package com.YueDao.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity
@Table(name = "Admin", catalog = "YueDao")
public class Admin {

	private int Id;
	
	private String username;
	private String password;
	private String truename;

	@Id
	@Column(name = "Id", unique = true, nullable = false, length = 32)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	@Column(name = "truename")
	public String getTruename()
	{
		return truename;
	}
	public void setTruename(String truename) 
	{
		this.truename = truename;
	}


}
