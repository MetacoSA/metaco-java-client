package com.metaco.client;

import org.junit.Test;

public class MetacoClientImplOrdersTest {
    @Test
    public void clientCanCreateAccount() {
    }

    @Test
    public void clientCanGetAccountStatus() {
        MetacoClient client = new MetacoClientBuilder()
                .withTestingMode(true)
                .makeClient();

        client.GetAccountStatus();
    }

    @Test
    public void clientCanValidateAccount() {

    }
}
