package com.metaco.api.utils;

import com.metaco.api.contracts.Issuer;
import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class DeserializationUtilsTest {
    @Test
    public void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = DeserializationUtils.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor is not private", Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void deserializationUtilsCanConvertToObject() {
        String json = "{\"name\": \"Metaco SA\",\"address\": \"Avenue du Bitcoin 1337\",\"contact\": \"metaco@dkybank.com\"}";

        Issuer issuer = DeserializationUtils.ToObject(json, Issuer.class);

        Assert.assertNotNull(issuer);
        Assert.assertEquals(issuer.getAddress(), "Avenue du Bitcoin 1337");
        Assert.assertEquals(issuer.getContact(), "metaco@dkybank.com");
        Assert.assertEquals(issuer.getName(), "Metaco SA");
    }

    @Test
    public void deserializationUtilsCantConvertToObject() {
        String json = "this is not json";

        Issuer issuer = DeserializationUtils.ToObject(json, Issuer.class);

        Assert.assertNull(issuer);
    }
}
