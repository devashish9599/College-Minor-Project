package com.finduponproject.model;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String password;
    private String number;
    
    @Column(name = "pic" , length = 2000)
    @Nullable
	 byte[] pic;
    
	String base64Encoded;
	
	/*@OneToOne(cascade = CascadeType.ALL, fetch  = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;*/
	
	

    /*public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}*/

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + ", number=" + number + ", roles=" + roles + "]";
	}

	public User(Long id, String name, String address, String email, String password, String number, byte[] pic, String encode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.number = number;
		this.pic = pic;
		this.base64Encoded = encode;
		
	}

	public User(Long id, String name, String address, String email, String password, String number,
			 byte[] pic, String encode,Collection<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.number = number;
		this.pic = pic;
		this.base64Encoded = encode;
		this.roles = roles;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

   
	
}
