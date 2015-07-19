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
@Table(name = "goods", catalog = "YueDao")
public class Goods {

	private int Id;
	
	private String name;
	private float price;
	private String info;
	private String description;
	private int praise;
	private String imageurl1;
	private String imageurl2;
	private String imageurl3;
	private String imageurl4;
	private String imageurl5;

	@Id
	@Column(name = "Id", unique = true, nullable = false, length = 32)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
	@Column(name = "name")
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	@Column(name = "price")
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}

	@Column(name = "info")
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info) 
	{
		this.info = info;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	@Column(name = "praise")
	public int getPraise()
	{
		return praise;
	}
	public void setPraise(int praise) 
	{
		this.praise = praise;
	}

	@Column(name = "imageurl1")
	public String getImageurl1()
	{
		return imageurl1;
	}
	public void setImageurl1(String imageurl1) 
	{
		this.imageurl1 = imageurl1;
	}

	@Column(name = "imageurl2")
	public String getImageurl2()
	{
		return imageurl2;
	}
	public void setImageurl2(String imageurl2) 
	{
		this.imageurl2 = imageurl2;
	}

	@Column(name = "imageurl3")
	public String getImageurl3()
	{
		return imageurl3;
	}
	public void setImageurl3(String imageurl3) 
	{
		this.imageurl3 = imageurl3;
	}

	@Column(name = "imageurl4")
	public String getImageurl4()
	{
		return imageurl4;
	}
	public void setImageurl4(String imageurl4) 
	{
		this.imageurl4 = imageurl4;
	}

	@Column(name = "imageurl5")
	public String getImageurl5()
	{
		return imageurl5;
	}
	public void setImageurl5(String imageurl5) 
	{
		this.imageurl5 = imageurl5;
	}


}
