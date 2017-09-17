package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity //annotation for every pojo
@Table(name="seller") //table name
@PrimaryKeyJoinColumn(name="personID") // for reference to superclass using foreign key
public class Seller extends Person {

	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password")
    private String passwrod;
    //private Address address;
    //private Date joinedDate;
	
	@Column(name="email")
    private String email;
    
    public Seller(String username, String password) {
    	this.username = username;
        this.passwrod= password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
