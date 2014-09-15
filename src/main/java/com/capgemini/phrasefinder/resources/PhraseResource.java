package com.capgemini.phrasefinder.resources;

import com.capgemini.phrasefinder.service.PhraseServiceServiceImpl;
import com.capgemini.phrasefinder.service.api.PhraseService;
import io.dropwizard.auth.Auth;
import org.fest.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Somaiah Kumbera (Capgemini)
 *         <p/>
 *         A Resource class to handle REST APIs for phrases
 */

@Path("/phrase")
@Produces(MediaType.APPLICATION_JSON)
public class PhraseResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhraseResource.class);
    private PhraseService phraseService = PhraseServiceServiceImpl.INSTANCE;

    /**
     * Fetches a phrase identified by an id.
     *
     * @param id              the phrase id to be fetched.
     * @param isAuthenticated a boolean value to indicate if the request is authenticated. This value is set by dropwizard
     * @return A {@link Response} object, containing a JSON represention of the phrase object
     */
    @GET
    @Path("/{id}")
    public Response getPhrase(@PathParam("id") int id, @Auth(required = false) Boolean isAuthenticated) {

        LOGGER.info("getPhrase called with id={}", id);

        String phrase = phraseService.getPhrase(id);
        return Response
                .ok("{phrase_id: " + id + ", phrase: " + phrase + " }")
                .status(Strings.isNullOrEmpty(phrase) ? Response.Status.BAD_REQUEST : Response.Status.OK)
                .build();
    }

    /**
     * Stores a phrase.
     *
     * @param phrase          the phrase {@link String} to be created and stored.
     * @param isAuthenticated a boolean value to indicate if the request is authenticated. This value is set by dropwizard
     * @return A {@link Response} object, with an appropriate status code
     */

    @POST
    public Response createPhrase(@FormParam("phrase") String phrase, @Auth Boolean isAuthenticated) {

        LOGGER.info("createPhrase called with phrase={}", phrase);

        if (Strings.isNullOrEmpty(phrase)) {

            LOGGER.error("phrase is empty or null. Returning BAD REQUEST");
            return Response
                    .created(null)
                    .status(Response.Status.BAD_REQUEST)
                    .build();

        }

        // TODO Question for group discussion: Whats wrong here?

        boolean success = phraseService.createPhrase(phrase);

        LOGGER.info("phrase created.");
        return Response
                .created(null)
                .status(success ? Response.Status.CREATED : Response.Status.INTERNAL_SERVER_ERROR)
                .build();
    }

    /**
     * Deletes a phrase.
     *
     * @param id              the phrase id to be deleted.
     * @param isAuthenticated a boolean value to indicate if the request is authenticated. This value is set by dropwizard
     * @return A {@link Response} object, with an appropriate status code
     */

    @DELETE
    @Path("/{id}")
    public Response deletePhrase(@PathParam("id") int id, @Auth Boolean isAuthenticated) {

        // TODO Question for group discussion: Whats wrong here?

        boolean success = phraseService.deletePhrase(id);

        return Response
                .noContent()
                .status(success ? Response.Status.NO_CONTENT : Response.Status.INTERNAL_SERVER_ERROR)
                .build();
    }

    /**
     * Updates a phrase.
     *
     * @param id              the phrase id to be updated.
     * @param phrase          the phrase {@link String} with the new value of the phrase.
     * @param isAuthenticated a boolean value to indicate if the request is authenticated. This value is set by dropwizard
     * @return A {@link Response} object, with an appropriate status code
     */

    // TODO Question for group discussion: Do we need PUT?
    @PUT
    @Path("/{id}")
    public Response updatePhrase(@PathParam("id") int id, @FormParam("phrase") String phrase, @Auth Boolean isAuthenticated) {

        // TODO Question for group discussion: Whats wrong here?

        if (Strings.isNullOrEmpty(phrase)) {
            return Response
                    .created(null)
                    .status(Response.Status.BAD_REQUEST)
                    .build();

        }

        boolean success = phraseService.updatePhrase(id, phrase);
        return Response
                .ok("{phrase_id: " + id + ", phrase: \"" + phrase + "\" }")
                .status(success ? Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .build();
    }

}
