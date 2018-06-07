package com.srh.clms.entities;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class DetailInfo {
	private int infoId;
	private String firstName;
	private String lastName;
	private String address;
	private String contact;
	private String email;
	private String username;
	private String password;
	private Date birthDate;
	private char gender;
	private BufferedImage useImage;
	private String userType;
	private int rating;
	private int accountId;
	
	public DetailInfo()
	{
		
	}
	public DetailInfo(int infoId, String firstName, String lastName, String address, String contact, String email,
			String username, String password, Date birthDate, char gender, BufferedImage useImage, String userType,
			int rating, int accountId) 
	{
		super();
		this.infoId = infoId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.useImage = useImage;
		this.userType = userType;
		this.rating = rating;
		this.accountId = accountId;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public BufferedImage getUseImage() {
		return useImage;
	}
	public void setUseImage(BufferedImage useImage) {
		this.useImage = useImage;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}	
}
