package org.bapan.service;

import org.bapan.model.Registration;

public interface RegistrationService {
	/**
	 * 
	 * @param registration
	 * @return
	 */
	Registration registerUser(Registration registration);
	/**
	 * 
	 * @param registration
	 * @return
	 */
	Registration verifyLogin(Registration registration);
}
