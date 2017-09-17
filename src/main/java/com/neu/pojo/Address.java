package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="address")
 //table per subclass

public class Address {
	 	
	//@Id
	//@Column(name="addressId", unique=true)
	 
	
	 @Id
	 @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="property"))
	 @GeneratedValue(generator="generator")
	 @Column(name="id", unique=true, nullable=false)
	private long id;
	
	 
	 @Column(name="streetName")
	private String streetName;
	 
	 @Column(name="city")
	    private String city;
	 
	 @Column(name="zipCode")
	    private String zipCode;
	    
//	    @OneToOne(fetch=FetchType.EAGER)
	 //@OneToOne(mappedBy="address")   
	 //@PrimaryKeyJoinColumn(name="id")
	 @OneToOne
	    @JoinColumn(name = "propertyID")
	   private Property property;
	    
	    public Address(String streetName, String city, String zipCode) {
	        
	        this.streetName= streetName;
	        this.city=city;
	        this.zipCode=zipCode;
	    }
	    
	    public Address() {
	        
	    }

	    

		public String getStreetName() {
			return streetName;
		}



		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}








		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public Property getProperty() {
			return property;
		}



		public void setProperty(Property property) {
			this.property = property;
		}



		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getZipCode() {
			return zipCode;
		}


		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

	    
			    
}
