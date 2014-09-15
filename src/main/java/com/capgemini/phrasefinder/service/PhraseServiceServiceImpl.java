package com.capgemini.phrasefinder.service;

import com.capgemini.phrasefinder.service.api.PhraseService;
import org.fest.util.Strings;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         An implementation class of the PhraseService class.
 */
public enum PhraseServiceServiceImpl implements PhraseService {

    /**
     * Ensures this is a Singleton.
     * Static variables of this class can be accessed as PhraseServiceServiceImpl.<varName>
     * Non-static variables can be accessed as PhraseServiceServiceImpl.INSTANCE.<varName>
     */
    INSTANCE;

    @Override
    public String getPhrase(int phraseId) {
        // Get a phrase from somewhere, perhaps a DB
        return phraseId == 100 ? "Space, the final frontier" : null;
    }

    @Override
    public boolean createPhrase(String phrase) {
        // Store the phrase string somewhere, perhaps a DB
        // ...

        return !Strings.isNullOrEmpty(phrase);
    }

    @Override
    public boolean deletePhrase(int phraseId) {
        // Delete the phrase string from the DB
        // ..

        return phraseId == 100;
    }

    @Override
    public boolean updatePhrase(int phraseId, String phrase) {
        // Update the phrase string identified by phraseId
        //..

        return phraseId == 100;
    }

}
