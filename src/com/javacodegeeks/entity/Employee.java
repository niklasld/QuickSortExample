package com.javacodegeeks.entity;

public class Employee implements Comparable<Employee>{

	private String firstName;
	private String lastName;
	private int emplyeeCode;
	
	public Employee(String fistName,String lastName,int emplyeeCode){
		this.firstName = fistName;
		this.lastName = lastName;
		this.emplyeeCode = emplyeeCode;
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
	public int getEmplyeeCode() {
		return emplyeeCode;
	}

	public void setEmplyeeCode(int emplyeeCode) {
		this.emplyeeCode = emplyeeCode;
	}

	public String toString(){
		return "Employee Code: "+getEmplyeeCode()+", Name:"+getFirstName()+" "+getLastName();
	}

	public int compareTo(Employee o) {
		Employee e = (Employee)o;
		if(this.emplyeeCode > e.getEmplyeeCode())
			return 1;
		if(this.emplyeeCode < e.getEmplyeeCode())
			return -1;
		if(this.emplyeeCode == e.getEmplyeeCode())
			return 0;
		return 0;
	}
}
