package com.apploidxxx.jshiki.auth;

import com.apploidxxx.jshiki.ShikiClient;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * @author Arthur Kupriyanov
 */
public class ShikiOAuth {
    public static String buildUserAuthUri(ShikiClient shikiClient, Scope scope) throws URISyntaxException {

        return new URIBuilder()
                .setScheme("https")
                .setHost("shikimori.one/oauth/authorize")
                .setParameter("client_id", shikiClient.CLIENT_ID)
                .setParameter("redirect_uri", shikiClient.REDIRECT_URI)
                .setParameter("response_type", "code")
                .setParameter("scope", scope.getScopesForUri())
                .build().toString();

    }
}
