package com.apploidxxx.jshiki;

import lombok.Getter;

/**
 * @author Arthur Kupriyanov
 */

public class ShikiClient {
    public final String CLIENT_ID;
    public final String CLIENT_SECRET;
    public final String REDIRECT_URI;

    private ShikiClient(String clientId, String clientSecret, String redirectUri){
        CLIENT_ID = clientId;
        CLIENT_SECRET = clientSecret;
        REDIRECT_URI = redirectUri;
    }





    public static ShikiClientBuilder create(){
        return new ShikiClientBuilder();
    }

    public static class ShikiClientBuilder {
        private String clientId;
        private String clientSecret;
        private String redirectUri = "urn:ietf:wg:oauth:2.0:oob";

        public ShikiClientBuilder clientId(String clientId){
            this.clientId = clientId;
            return this;
        }

        public ShikiClientBuilder clientSecret(String clientSecret){
            this.clientSecret = clientSecret;
            return this;
        }

        public ShikiClientBuilder redirectUri(String redirectUri){
            this.redirectUri = redirectUri;
            return this;
        }

        public ShikiClient build(){
            return new ShikiClient(clientId, clientSecret, redirectUri);
        }
    }
}
