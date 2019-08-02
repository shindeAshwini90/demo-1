package com.example.demo.dtos;

import javax.validation.constraints.NotNull;

public class Student {
	private int stuId;
	private String firstName;
	private String address;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	@NotNull(message = "name should not be null")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", firstName=" + firstName + ", address=" + address + "]";
	}

}
