package com.brt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_dtls")
public class LoginDtls {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOGINDTLS_ID")
	private int logindtlsId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PWD")
	private String pwd;
	
	
	
	public int getLogindtlsId() {
		return logindtlsId;
	}
	public void setLogindtlsId(int logindtlsId) {
		this.logindtlsId = logindtlsId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LoginDtls [logindtlsId=" + logindtlsId + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
	
	
	
	
}
