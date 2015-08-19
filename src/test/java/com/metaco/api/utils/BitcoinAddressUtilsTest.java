package com.metaco.api.utils;

import junit.framework.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class BitcoinAddressUtilsTest {

    private static String REGULAR_ADDRESS = "16UwLL9Risc3QfPqBUvKofHmBQ7wMtjvM";
    private static String COLORED_ADDRESS = "akB4NBW9UuCmHuepksob6yfZs6naHtRCPNy";

    private static String REGULAR_TESTNET_ADDRESS = "n2eMqTT929pb1RDNuqEnxdaLau1rxy3efi";
    private static String COLORED_TESTNET_ADDRESS = "bXCcF5dGUVdiGsfNjxTLycVUuvWC2skdeyK";

    @Test
    public void canConvertToRegularAddress() throws NoSuchAlgorithmException {
        String regularAddress = BitcoinAddressUtils.toRegularAddress(COLORED_ADDRESS);
        Assert.assertEquals(regularAddress, REGULAR_ADDRESS);

        regularAddress = BitcoinAddressUtils.toRegularAddress(COLORED_TESTNET_ADDRESS);
        Assert.assertEquals(regularAddress, REGULAR_TESTNET_ADDRESS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canHandleInvalidColoredAddress() throws NoSuchAlgorithmException {
        String regularAddress = BitcoinAddressUtils.toRegularAddress("azerty");
        Assert.assertEquals(regularAddress, REGULAR_ADDRESS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canHandleInvalidRegularAddress() throws NoSuchAlgorithmException {
        String coloredAddress = BitcoinAddressUtils.toColoredAddress("azerty");
        Assert.assertEquals(coloredAddress, COLORED_ADDRESS);
    }

    @Test
    public void canConvertToColoredAddress() throws NoSuchAlgorithmException {
        String coloredAddress = BitcoinAddressUtils.toColoredAddress(REGULAR_ADDRESS);
        Assert.assertEquals(coloredAddress, COLORED_ADDRESS);

        coloredAddress = BitcoinAddressUtils.toColoredAddress(REGULAR_TESTNET_ADDRESS);
        Assert.assertEquals(coloredAddress, COLORED_TESTNET_ADDRESS);
    }

    @Test
    public void canDetectColoredAddress() throws NoSuchAlgorithmException {
        Assert.assertTrue(BitcoinAddressUtils.isColoredAddress(COLORED_ADDRESS));
        Assert.assertFalse(BitcoinAddressUtils.isColoredAddress(REGULAR_ADDRESS));

        Assert.assertTrue(BitcoinAddressUtils.isColoredAddress(COLORED_TESTNET_ADDRESS));
        Assert.assertFalse(BitcoinAddressUtils.isColoredAddress(REGULAR_TESTNET_ADDRESS));
    }

    @Test
    public void canDetectRegularAddress() throws NoSuchAlgorithmException {
        Assert.assertTrue(BitcoinAddressUtils.isRegularAddress(REGULAR_ADDRESS));
        Assert.assertFalse(BitcoinAddressUtils.isRegularAddress(COLORED_ADDRESS));

        Assert.assertTrue(BitcoinAddressUtils.isRegularAddress(REGULAR_TESTNET_ADDRESS));
        Assert.assertFalse(BitcoinAddressUtils.isRegularAddress(COLORED_TESTNET_ADDRESS));
    }
}
