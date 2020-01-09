package com.apploidxxx.jshiki.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arthur Kupriyanov
 */
public class Scope {

    private Set<ScopeEnum> scopes = new HashSet<>();

    public Scope addScope(ScopeEnum scopeEnum){
        scopes.add(scopeEnum);
        return this;
    }

    public String getScopesForUri(){
        StringBuilder sb = new StringBuilder();
        scopes.forEach(s -> sb.append(s).append("+"));
        String scope = sb.toString();
        if (scope.endsWith("+")) scope = scope.substring(0, scope.length() -1);

        return scope;
    }

    public static Scope setScopes(ScopeEnum ... scopeEnums){
        Scope scope = new Scope();
        scope.scopes.addAll(Arrays.asList(scopeEnums));
        return scope;
    }

    public enum ScopeEnum {
        USER_RATES{
            @Override
            public String toString() {
                return "user_rates";
            }
        }, COMMENTS{
            @Override
            public String toString() {
                return "comments";
            }
        }, TOPICS{
            @Override
            public String toString() {
                return "topics";
            }
        };

    }
}
