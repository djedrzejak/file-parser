package pl.djedrzejak.parser.fileparser.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Person {

	private String name;
	private String address;
	private String postcode;
	private String phone;
	private BigDecimal creditLimit;
	private LocalDate birthday;
	private String fileExtension;

	public Person(String name, String address, String postcode, String phone, BigDecimal creditLimit, LocalDate birthday) {
		this.name = name;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
		this.creditLimit = creditLimit;
		this.birthday = birthday;
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
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + " | address=" + address + " | postcode=" + postcode + " | phone=" + phone
				+ " | creditLimit=" + creditLimit.toString() + " | birthday=" + birthday.toString() + " | fileExtension=" + fileExtension + "]";
	}
}