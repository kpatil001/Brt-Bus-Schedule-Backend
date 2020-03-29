package com.brt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_details")
public class EmployeeDtl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="EMP_FIRSTNAME")
	private String empFirstName;
	
	@Column(name="EMP_LASTNAME")
	private String empLastName;
	
	@Column(name="EMP_AGE")
	private int empAge;
	
	@Override
	public String toString() {
		return "EmployeeDtl [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empAge=" + empAge + "]";
	}

	public EmployeeDtl(){}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

}
