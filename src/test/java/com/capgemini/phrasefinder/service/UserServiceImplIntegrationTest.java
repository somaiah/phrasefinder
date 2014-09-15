package com.capgemini.phrasefinder.service;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         Integration tests of the {@link UserServiceImpl} class.
 */

public class UserServiceImplIntegrationTest extends TestCase {

    private static String VALID_USERNAME = "star";
    private static String VALID_PASSWORD = "trek";
    private static String INVALID_USERNAME = "redshirt";
    private static String INVALID_PASSWORD = "survives";
    private UserServiceImpl service = UserServiceImpl.INSTANCE;

    /**
     * Tests <code>validateUser</code> for valid and invalid creds.
     */
    @Test
    public void testValidateUser() {

        assertThat(service.validateUser(VALID_USERNAME, VALID_PASSWORD), is(true));
        assertThat(service.validateUser(INVALID_USERNAME, INVALID_PASSWORD), is(false));

    }

    /**
     * Tests <code>retrieveUserCount</code>. This returns the number of users in the repo. This
     * value should be greater than 0
     */
    @Test
    public void testRetrieveUserCount() {

        assertThat(service.retrieveUserCount(), is(greaterThan(0)));

    }

}
