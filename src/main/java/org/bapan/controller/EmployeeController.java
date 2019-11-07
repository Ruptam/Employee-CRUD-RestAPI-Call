/**
 * 
 */
package org.bapan.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bapan.model.Employee;
import org.bapan.model.Registration;
import org.bapan.service.EmployeeService;
import org.bapan.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ruptam
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	private List<Employee> employees = createEmployeeList();
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/employees")
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> employees = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		Employee addedEmployee = empService.saveEmployee(employee);
		return new ResponseEntity<Employee>(addedEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/employee/{name}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("name") String name) {
		/*Iterator<Employee> empIterator = employees.iterator();
		Employee employee = new Employee();
		while(empIterator.hasNext()) {
			employee = empIterator.next();
			if(employee.getEmpName().equals(name)) {
				empService.deleteEmployee(employee);
				break;
			}
		}*/
		empService.deleteEmployee(name);
		return new ResponseEntity<String>("Employee " + name + " deleter succesfully", HttpStatus.OK);
	}
	
	@PutMapping(value = "/employee")
	public ResponseEntity<?> updateSalary(@RequestBody Employee employee) {
		Employee emp = empService.updateSalary(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody Registration registration) {
		Registration alreadyRegistered = registrationService.registerUser(registration);
		return new ResponseEntity<Registration>(alreadyRegistered, HttpStatus.OK);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody Registration registration) {
		Registration isRegistered = registrationService.verifyLogin(registration);
		System.out.println("Is Registered **** " + isRegistered);
		if(isRegistered != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	private List<Employee> createEmployeeList() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setAge(20);
		emp1.setEmpName("John");
		emp1.setSalary(20000);
		
		Employee emp2 = new Employee();
		emp2.setAge(20);
		emp2.setEmpName("Peter");
		emp2.setSalary(25000);
		
		allEmployees.add(emp1);
		allEmployees.add(emp2);
		
		return allEmployees;
	}

}
