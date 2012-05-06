package com.fusesource.training.pojocodefirst;


public class Customer  {
	private String firstName;
	private String lastName;
	private String skypeId;
	private String telephoneNumber;
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

