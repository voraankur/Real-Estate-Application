package com.neu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="property")
 //table per subclass

public class Property  {
	
	@Id
	@GeneratedValue
	@Column(name="propertyID", unique=true, nullable=false)
	private long propertyID;
	
	@Column(name="propertyType")
	private String propertyType;
	
	@OneToOne(fetch=FetchType.EAGER , mappedBy = "property", cascade= CascadeType.ALL)
	private Address address;
	
	@Column(name="noOfBeds")
	private String noOfBeds;
	
	@Column(name="noOfBathrooms")
	private String noOfBathrooms;
	
	@Column(name="price")
	private String price;
	
	@Column(name="area")
	private String area;
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="newOwner")
	private String newOwner;
	
	@Column(name="status")
	private String status;
	
/*	@Column(name="zipcode")
	private String zipcode;
*/	
	
	public Property(String propertyType, String noOfBeds, String noOfBathrooms,
			String price, String area, String owner, String status){
		this.propertyType = propertyType;
		this.noOfBeds = noOfBeds;
		this.noOfBathrooms = noOfBathrooms;
		this.price = price;
		this.area = area;
		this.owner = owner;
		this.status= status;
		//this.zipcode=zipcode;
	}
	
	public Property(){
		
	}
	
	
	public long getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}

	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

	public String getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public String getNoOfBathrooms() {
		return noOfBathrooms;
	}

	public void setNoOfBathrooms(String noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	public String getNewOwner() {
		return newOwner;
	}

	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
*/	
	
}
