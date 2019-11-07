/**
 * 
 */
package org.bapan.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bapan.model.Employee;
import org.bapan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ruptam
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	/**
	 * 
	 */
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}
	/**
	 * 
	 */
	public List<Employee> getAllEmployees() {
		Iterable<Employee> empIterable = empRepository.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		empIterable.forEach(employees::add);
		return employees;
	}
	@Override
	public Employee deleteEmployee(String employeeName) {
		empRepository.deleteByEmpName(employeeName);
		return null;
	}
	@Override
	public Employee updateSalary(Employee employee) {
		Iterable<Employee> empIterable = empRepository.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		empIterable.forEach(employees::add);
		Employee emp = null;
		Iterator<Employee> empIterator = employees.iterator();
		while(empIterator.hasNext()) {
			emp = empIterator.next();
			if(emp.getEmpName().equals(employee.getEmpName())) {
				empRepository.deleteByEmpName(emp.getEmpName());
				emp.setSalary(employee.getSalary());
				empRepository.save(emp);
				break;
			}
		}
		return emp;
	}

}
