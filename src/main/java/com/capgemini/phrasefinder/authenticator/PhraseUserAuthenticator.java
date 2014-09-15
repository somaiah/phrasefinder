package com.capgemini.phrasefinder.authenticator;

import com.capgemini.phrasefinder.service.UserServiceImpl;
import com.capgemini.phrasefinder.service.api.UserService;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         An authenticator class to validate users. The actual user check is done in
 *         the UserService implementation class
 */
public class PhraseUserAuthenticator implements Authenticator<BasicCredentials, Boolean> {

    private UserService userService = UserServiceImpl.INSTANCE;

    public PhraseUserAuthenticator() {
    }

    @Override
    public Optional<Boolean> authenticate(BasicCredentials c) throws AuthenticationException {
        boolean validUser = userService.validateUser(c.getUsername(), c.getPassword());

        if (validUser) {
            return Optional.of(true);
        }
        return Optional.absent();
    }
}