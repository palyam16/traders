package com.virtusa.traders.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;
@Entity
@Table(name="VS_USERS")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="User_Id")
	private int userId;
	
	
	@Column(name="User_Name",length = 50)
	private String userName;
	
	@Column(name="Password", nullable = false)
	private String password;
	
	@Column(name="First_Name", nullable= false,length=70)
	private String firstName;
	
	@Column(name="Last_Name", nullable= false,length=70)
	private String lastName;
	
	@Column(name="Date_Of_Joining")
	@DateTimeFormat(iso= ISO.DATE)
	private String dateOfJoining;
	
	@Column(name="Bank_Id")
	private String bankId;
	
	@Column(name="Dob")
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate dob;
	
	@Column(name="Email_Id", nullable= false, length=100)
	private String emailId;
	
	@Column(name="Primary_Phone_No")
	private String primaryPhoneNo;
	
	@Column(name="Secondary_Phone_No")
	private String  secondaryPhoneNo;
	
	public String getSecondaryPhoneNo() {
		return secondaryPhoneNo;
	}



	public void setSecondaryPhoneNo(String secondaryPhoneNo) {
		this.secondaryPhoneNo = secondaryPhoneNo;
	}



	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonProperty("roles")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Role> roles;
	
	public User(String username, String password, List<Role> roles) {
        super();
        this.userName = username;
        this.password = password;
        this.roles = roles;
    }



    public User() {
        super();
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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



	public String getDateOfJoining() {
		return dateOfJoining;
	}



	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPrimaryPhoneNo() {
		return primaryPhoneNo;
	}



	public void setPrimaryPhoneNo(String primaryPhoneNo) {
		this.primaryPhoneNo = primaryPhoneNo;
	}
	


}
