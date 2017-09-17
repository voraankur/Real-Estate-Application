package com.neu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity //annotation for every pojo
@Table(name="user") //table name
@PrimaryKeyJoinColumn(name="personID") // for reference to superclass using foreign key
public class User extends Person {
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password")
    private String password;
    //private Address address;
    
	/*@Column(name="email")
    private String email;
*/	
	  @OneToOne(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	     private Email email;
	
	@Column(name="usertype")
    private String usertype;
	
    public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public User(String username, String password, String usertype) {
        
    	this.username = username;
        this.password= password;
        //this.email=email;
        this.usertype= usertype;
    }
    
   public User(){
    	
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

/*	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/
    
    
}
