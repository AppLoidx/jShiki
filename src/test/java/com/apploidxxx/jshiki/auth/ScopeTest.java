package com.apploidxxx.jshiki.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Arthur Kupriyanov
 */
class ScopeTest {

    @org.junit.jupiter.api.Test
    void getScopesForUri() {
        Scope scope = new Scope();

        scope.addScope(Scope.ScopeEnum.USER_RATES);
        scope.addScope(Scope.ScopeEnum.USER_RATES);
        scope.addScope(Scope.ScopeEnum.COMMENTS);

        String uriScope = scope.getScopesForUri();
        String[] variables = uriScope.split("\\+");
        assertEquals(2, variables.length);
        assertTrue(
                variables[0].equals(Scope.ScopeEnum.USER_RATES.toString())
                || variables[0].equals(Scope.ScopeEnum.COMMENTS.toString()));
        assertTrue(
                variables[1].equals(Scope.ScopeEnum.USER_RATES.toString())
                || variables[1].equals(Scope.ScopeEnum.COMMENTS.toString()));

        assertNotEquals(variables[0], variables[1]);

        assertNotHaveAdditionalPlus(uriScope);
    }

    @Test
    void setScopes() {

        String uriScope = Scope.setScopes(Scope.ScopeEnum.USER_RATES, Scope.ScopeEnum.COMMENTS).getScopesForUri();
        String[] variables = uriScope.split("\\+");
        assertEquals(2, variables.length);
        assertTrue(
                variables[0].equals(Scope.ScopeEnum.USER_RATES.toString())
                        || variables[0].equals(Scope.ScopeEnum.COMMENTS.toString()));
        assertTrue(
                variables[1].equals(Scope.ScopeEnum.USER_RATES.toString())
                        || variables[1].equals(Scope.ScopeEnum.COMMENTS.toString()));

        assertNotEquals(variables[0], variables[1]);

        assertNotHaveAdditionalPlus(uriScope);
    }

    void assertNotHaveAdditionalPlus(String uriParam){
        assertTrue(uriParam.charAt(0) != '+');
        assertTrue(uriParam.charAt(uriParam.length() - 1) != '+');
    }
}