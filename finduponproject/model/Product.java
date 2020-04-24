package com.finduponproject.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
    String name;
	private long price;
	private String type;
	@Column(name = "pic", length = 2000)
	private byte[] pic;
	private String base64Encoded;
	
	private String description;
	
	private String picName;
	

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product() {
		
	}

	public Product(long id, String name, long price, String type, byte[] pic, String base64Encoded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.pic = pic;
		this.base64Encoded = base64Encoded;
	}
	
	
	
	

	public Product(String name, long price, String type, byte[] pic, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.pic = pic;
		this.description = desc;
	}

	
	

	public Product(long id, String name, long price, String type, byte[] pic, String base64Encoded, String description,
			String picName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.pic = pic;
		this.base64Encoded = base64Encoded;
		this.description = description;
		this.picName = picName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", pic="
				+ Arrays.toString(pic) + ", base64Encoded=" + base64Encoded + ", description=" + description
				+ ", picName=" + picName + "]";
	}

	

}
