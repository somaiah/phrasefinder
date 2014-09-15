package com.capgemini.phrasefinder.health;

import com.capgemini.phrasefinder.service.UserServiceImpl;
import com.capgemini.phrasefinder.service.api.UserService;
import com.codahale.metrics.health.HealthCheck;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         This class is called by Dropwizard to perform healthchecks (when registered in the Application subclass)
 */
public class UserRepoHealthCheck extends HealthCheck {

    private UserService userService = UserServiceImpl.INSTANCE;

    public UserRepoHealthCheck() {
    }

    @Override
    protected Result check() throws Exception {

        userService.retrieveUserCount();
        return Result.healthy();
    }
}