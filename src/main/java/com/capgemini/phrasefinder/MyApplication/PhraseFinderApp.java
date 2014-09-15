package com.capgemini.phrasefinder.MyApplication;

import com.capgemini.phrasefinder.MyApplicationConfiguration.PhaseFinderAppConfiguration;
import com.capgemini.phrasefinder.authenticator.PhraseUserAuthenticator;
import com.capgemini.phrasefinder.health.UserRepoHealthCheck;
import com.capgemini.phrasefinder.resources.PhraseResource;
import com.google.common.cache.CacheBuilderSpec;
import io.dropwizard.Application;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         The Application subclass initializes and starts the dropwizard application
 *         Resources, Authenticators, HealthChecks should be registered here
 */
public class PhraseFinderApp extends Application<PhaseFinderAppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhraseFinderApp.class);

    public static void main(String[] args) throws Exception {
        new PhraseFinderApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<PhaseFinderAppConfiguration> b) {
    }

    @Override
    public void run(PhaseFinderAppConfiguration configuration, Environment environment)
            throws Exception {

        LOGGER.info("Starting up dropwizard application. Method PhraseFinderApp#run() called");

        environment.jersey().register(new PhraseResource());

        CachingAuthenticator<BasicCredentials, Boolean> authenticator = new CachingAuthenticator<>(
                environment.metrics(),
                new PhraseUserAuthenticator(),
                CacheBuilderSpec.parse("maximumSize=10000, expireAfterAccess=0m"));
        environment.jersey().register(new BasicAuthProvider<>(authenticator, "Web Service Realm"));

        final UserRepoHealthCheck healthCheck = new UserRepoHealthCheck();
        environment.healthChecks().register("userRepo", healthCheck);

    }
}
