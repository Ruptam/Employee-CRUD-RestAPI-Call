package org.bapan.repository;

import org.bapan.model.Registration;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author ruptam
 *
 */
public interface RegistrationRepo extends CrudRepository<Registration, String> {
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	Registration findByEmailAndPassword(String email, String password);
}
