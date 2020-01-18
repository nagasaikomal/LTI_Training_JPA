package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="dept")
public class Department implements Serializable {
	@Id
	@Column(name="dept_id")
	private int departmentId;
	@Column(name="dept_name")
	private String departmentName;
	@Transient
	private String city;
	
    @OneToMany(mappedBy="department",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Employee> employee=new HashSet<>();
	public Department(){
		
	}
	
	
	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Set<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	

}
