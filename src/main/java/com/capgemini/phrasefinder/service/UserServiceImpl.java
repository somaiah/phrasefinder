package com.capgemini.phrasefinder.service;

import com.capgemini.phrasefinder.service.api.UserService;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         An implementation class of the PhraseService class.
 */
public enum UserServiceImpl implements UserService {

    /**
     * Ensures this is a Singleton.
     * Static variables of this class can be accessed as UserServiceImpl.<varName>
     * Non-static variables can be accessed as UserServiceImpl.INSTANCE.<varName>
     */
    INSTANCE;

    @Override
    public boolean validateUser(String username, String password) {
        // Do a more meaningful user check here
        return ("star".equalsIgnoreCase(username) && "trek".equalsIgnoreCase(password));
    }

    @Override
    public int retrieveUserCount() {
        // Do a more meaningful count of the users here, from the user repo
        return 1;
    }

}
