package com.capgemini.phrasefinder.service;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         Integration tests of the {@link PhraseServiceServiceImpl} class.
 */

public class PhraseServiceImplIntegrationTest extends TestCase {

    private static int EXISTING_PHRASE_ID = 100;
    private static int NON_EXISTING_PHRASE_ID = 99;
    private static String PHRASE_TO_INSERT = "Revenge is a dish best served cold - Klingon proverb";
    private PhraseServiceServiceImpl service = PhraseServiceServiceImpl.INSTANCE;

    /**
     * Tests <code>getPhrase</code> for valid and invalid ids.
     */
    @Test
    public void testGetPhrase() {

        assertThat(service.getPhrase(EXISTING_PHRASE_ID), is(not(isEmptyOrNullString())));
        assertThat(service.getPhrase(NON_EXISTING_PHRASE_ID), is(isEmptyOrNullString()));
    }

    /**
     * Tests <code>createPhrase</code> for valid and invalid ids.
     */
    @Test
    public void testCreatePhrase() {

        assertThat(service.createPhrase(PHRASE_TO_INSERT), is(true));
        assertThat(service.createPhrase(null), is(false));
    }

    /**
     * Tests <code>deletePhrase</code> for valid and invalid ids.
     */
    @Test
    public void testDeletePhrase() {

        assertThat(service.deletePhrase(EXISTING_PHRASE_ID), is(true));
        assertThat(service.deletePhrase(NON_EXISTING_PHRASE_ID), is(false));
    }

    /**
     * Tests <code>updatePhrase</code>.
     */
    @Test
    public void testUpdatePhrase() {

        assertThat(service.updatePhrase(EXISTING_PHRASE_ID, PHRASE_TO_INSERT), is(true));

    }
}
