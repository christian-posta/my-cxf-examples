package com.iona.ps.restful;

// Note: you must annotate classes to be marshalled as XML with jax-b annotations.
@javax.xml.bind.annotation.XmlRootElement
public class Customer  {
	private String firstName;
	private String lastName;
	private String skypeId;
	private String telephoneNumber;
	private String id; 


	private int age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// Note that you must provide a zero-argument default constructor
    // for objects that are to be marshalled on the wire.
    //
	public Customer() {		
	}
	
	public Customer(String firstName, String lastName, String skypeId,
			String telephoneNumber, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.skypeId = skypeId;
		this.telephoneNumber = telephoneNumber;
		this.age = age;
	} 	
}

