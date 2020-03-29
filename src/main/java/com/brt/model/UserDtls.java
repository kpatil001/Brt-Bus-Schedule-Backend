package com.brt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserDtls")
public class UserDtls {
	
	@Id
	@Column(name="USERDTLS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  userdtlsId; 
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PHONE_NO")
	private String phoneNo;
	@Column(name="ADDRESS")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="LOGINDTLS_ID")
	private LoginDtls loginDtls;
	
	
	
	public int getUserdtlsId() {
		return userdtlsId;
	}
	public void setUserdtlsId(int userdtlsId) {
		this.userdtlsId = userdtlsId;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LoginDtls getLoginDtls() {
		return loginDtls;
	}
	public void setLoginDtls(LoginDtls loginDtls) {
		this.loginDtls = loginDtls;
	}
	@Override
	public String toString() {
		return "UserDtls [userdtlsId=" + userdtlsId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNo=" + phoneNo + ", address=" + address + ", loginDtls=" + loginDtls + "]";
	}
	
	

}
