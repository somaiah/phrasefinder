package com.capgemini.phrasefinder.service.api;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         A Service class to handle user related queries
 */
public interface UserService {

    /**
     * validates a user against a password
     *
     * @param username the username {@link String}
     * @param password the password {@link String}
     * @return true if the credentials are correct, false otherwise
     */
    boolean validateUser(String username, String password);

    /**
     * A method to return the total number of users in the system
     *
     * @return an integer with the total number of users in the system
     */
    int retrieveUserCount();

}
