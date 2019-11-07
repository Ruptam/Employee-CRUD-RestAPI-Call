/**
 * 
 */
package org.bapan.repository;

import java.util.Optional;

import org.bapan.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ruptam
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, String> {
	/**
	 * 
	 * @param name
	 * @return
	 */
	void deleteByEmpName(String name);
	/**
	 * 
	 * @param name
	 * @return
	 */
	Optional<Employee> findByEmpName(String name);
}
