/**
 * 
 */
package org.bapan.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bapan.model.Registration;
import org.bapan.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ruptam
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo registrationRepo;
	/**
	 * 
	 */
	public Registration registerUser(Registration registration) {
		registration.setPassword(encryptPassword(registration.getPassword()));
		return registrationRepo.save(registration);
	}
	
	private String encryptPassword(String passwordToHash) {
		String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException  e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
	}
	/**
	 * 
	 */
	public Registration verifyLogin(Registration registration) {
		registration.setPassword(encryptPassword(registration.getPassword()));
		Registration regd = registrationRepo.findByEmailAndPassword(
							registration.getEmail(), registration.getPassword());
		return regd;
	}
}
