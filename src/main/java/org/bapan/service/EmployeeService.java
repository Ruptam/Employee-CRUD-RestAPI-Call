/**
 * 
 */
package org.bapan.service;

import java.util.Collection;
import java.util.List;

import org.bapan.model.Employee;

/**
 * @author ruptam
 *
 */
public interface EmployeeService {
	/**
	 * 
	 * @param employee
	 * @return
	 */
	Employee saveEmployee(Employee employee);
	/**
	 * 
	 * @return
	 */
	List<Employee> getAllEmployees();
	/**
	 * 
	 * @param employee
	 * @return
	 */
	Employee deleteEmployee(String employeeName);
	/**
	 * 
	 * @param employee
	 * @return
	 */
	Employee updateSalary(Employee employee);
}
