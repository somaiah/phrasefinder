package com.capgemini.phrasefinder.MyApplicationConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Somaiah Kumbera (Capgemini)
 */
public class PhaseFinderAppConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String dbURL;

    public String getDbURL() {
        return dbURL;
    }
}
