/**
 * 
 */
package org.bapan.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ruptam
 *
 */
@Document(collection = "employee")
public class Employee {
	/**
	 * 
	 */
	private String empName;
	/**
	 * 
	 */
	private int age;
	/**
	 * 
	 */
	private double salary;
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
