package com.capgemini.phrasefinder.service.api;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         A Service class to handle REST APIs for phrases
 */
public interface PhraseService {

    String getPhrase(int phraseId);
    boolean createPhrase(String phrase);
    boolean deletePhrase(int phraseId);
    boolean updatePhrase(int phraseId, String phrase);
}
