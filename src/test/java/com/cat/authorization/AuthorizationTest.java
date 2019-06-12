package com.cat.authorization;


import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AuthorizationTest {

    @Test
    public void doAuthorization() throws Exception {
        //GIVEN
        String trueString = "2a2c02f9ce5382573e7a7fffb6137806bad68cd8eb07b78de1ebe60a01f45d4b";
        //WHEN
        Authorization authorization = mock(Authorization.class);
        when(authorization.doAuthorization()).thenReturn(trueString);
        //THEN
        String result = authorization.doAuthorization();
        Assert.assertNotNull(result);
        Assert.assertEquals(result, trueString);
    }

}