package com.fusesource.training.codefirst;

/**
 * Created with IntelliJ IDEA.
 * User: cposta
 * Date: 5/4/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    private int age;
    private String firstName;
    private String lastName;
    private String skypeId;
    private String telephoneNumber;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
}
