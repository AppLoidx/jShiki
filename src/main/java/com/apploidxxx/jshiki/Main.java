package com.apploidxxx.jshiki;

import com.apploidxxx.jshiki.auth.Scope;
import com.apploidxxx.jshiki.auth.ShikiOAuth;

import java.net.URISyntaxException;

/**
 * @author Arthur Kupriyanov
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException {

        ShikiClient shikiClient = ShikiClient.create().clientId("123").clientSecret("123").build();


        System.out.println(ShikiOAuth.buildUserAuthUri(shikiClient, new Scope().addScope(Scope.ScopeEnum.USER_RATES)));
    }

}
