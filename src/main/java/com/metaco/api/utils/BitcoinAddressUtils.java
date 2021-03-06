package com.metaco.api.utils;

import com.metaco.api.encoders.Base58Check;

import java.security.NoSuchAlgorithmException;

public class BitcoinAddressUtils {

    private static byte OPEN_ASSETS_NAMESPACE = 19;
    private static byte P2PKH_MAIN_NET = 0x0;
    private static byte P2SH_MAIN_NET = 0x5;
    private static byte P2PKH_TEST_NET = 0x6F;
    private static byte P2SH_TEST_NET = (byte) 0xC4;
    private static byte[] VALID_VERSIONS = new byte[] {P2PKH_MAIN_NET, P2SH_MAIN_NET, P2PKH_TEST_NET, P2SH_TEST_NET};

    /**
     * Tries to convert a regular address to an open assets address
     * Will throw an exception if there is a conversion problem
     *
     * @return The open assets address
     */
    public static String toColoredAddress(String regularAddress) throws NoSuchAlgorithmException {
        validateRegularAddress(regularAddress);

        byte[] bytesValue = Base58Check.decode(regularAddress);

        byte[] colored = new byte[bytesValue.length + 1];

        colored[0] = OPEN_ASSETS_NAMESPACE;

        System.arraycopy(bytesValue, 0, colored, 1, bytesValue.length);

        return Base58Check.encode(colored);
    }

    /**
     * Tries to convert an open assets address to a regular address
     * Will throw an exception if there is a conversion problem
     *
     * @return The regular address
     */
    public static String toRegularAddress(String coloredAddress) throws NoSuchAlgorithmException {
        validateColoredAddress(coloredAddress);

        byte[] bytesValue = Base58Check.decode(coloredAddress);

        byte[] regular = new byte[bytesValue.length - 1];

        System.arraycopy(bytesValue, 1, regular, 0, bytesValue.length - 1);

        return Base58Check.encode(regular);
    }

    /**
     * Determines if the address is of the open asset type
     *
     * @return the result (boolean)
     */
    public static boolean isColoredAddress(String address) throws NoSuchAlgorithmException {
        try {
            validateColoredAddress(address);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Determines if the address is of the regular type
     *
     * @return the result (boolean)
     */
    public static boolean isRegularAddress(String address) throws NoSuchAlgorithmException {
        try {
            validateRegularAddress(address);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static void validateRegularAddress(String address) throws NoSuchAlgorithmException {
        byte[] bytesValue = Base58Check.decode(address);
        if (bytesValue.length != 21) {
            throw new IllegalArgumentException("address isn't a valid regular address : length too big");
        }

        boolean versionValidated = false;
        for (byte b: VALID_VERSIONS){
            if(bytesValue[0] == b) {
                versionValidated = true;
            }
        }
        if (!versionValidated) {
            throw new IllegalArgumentException("address isn't a valid regular address : version byte invalid");
        }
    }

    private static void validateColoredAddress(String address) throws NoSuchAlgorithmException {
        byte[] bytesValue = Base58Check.decode(address);
        if (bytesValue.length != 22) {
            throw new IllegalArgumentException("address isn't a valid colored address : length too big");
        }

        boolean versionValidated = false;
        for (byte b: VALID_VERSIONS){
            if(bytesValue[1] == b) {
                versionValidated = true;
            }
        }
        if (!versionValidated) {
            throw new IllegalArgumentException("address isn't a valid colored address : version byte invalid");
        }

        if (bytesValue[0] != OPEN_ASSETS_NAMESPACE) {
            throw new IllegalArgumentException("address isn't a valid colored address : namespace byte invalid");
        }
    }
}
