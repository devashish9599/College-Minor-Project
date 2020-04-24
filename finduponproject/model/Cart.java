package com.finduponproject.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;

	/*@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private User user;*/
	
	private String uId;
	
	private String pName;
	
	
	private long pPrice;
	
	private String type;
	
	private String picName; 
	
	

	
	
	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public long getpPrice() {
		return pPrice;
	}

	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}

	public Cart(String uId, String pName, long pPrice, String type,String picName) {
		super();
		this.uId = uId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.type = type;
		this.picName = picName;
	}
	
	

	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", uId=" + uId + ", pName=" + pName + ", pPrice=" + pPrice + ", type=" + type
				+ ", picName=" + picName + "]";
	}

	
	

	

	
	
		

}
