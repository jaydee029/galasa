/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.testharness;

import java.util.HashMap;

import javax.validation.constraints.NotNull;

import dev.galasa.ICredentials;
import dev.galasa.framework.spi.creds.CredentialsException;
import dev.galasa.framework.spi.creds.ICredentialsService;

public class InMemoryCreds implements ICredentialsService {
    
    public HashMap<String, ICredentials> credentials = new HashMap<>();

    @Override
    public ICredentials getCredentials(@NotNull String credentialsId) throws CredentialsException {
        return credentials.get(credentialsId);
    }

}
