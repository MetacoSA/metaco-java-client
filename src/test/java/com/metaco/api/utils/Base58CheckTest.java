package com.metaco.api.utils;

import helpers.Tuple;
import junit.framework.Assert;
import org.bitcoinj.core.AddressFormatException;
import org.bitcoinj.core.Base58;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base58CheckTest {

    List<Tuple<String, byte[]>> _testCases = new ArrayList<Tuple<String, byte[]>>();

    // Example address from https://en.bitcoin.it/wiki/Technical_background_of_version_1_Bitcoin_addresses
    private static byte[] ADDRESS_BYTES = new byte[] { 0x00, 0x01, 0x09, 0x66, 0x77, 0x60, 0x06, (byte) 0x95, 0x3D, 0x55, 0x67, 0x43, (byte) 0x9E, 0x5E, 0x39, (byte) 0xF8, 0x6A, 0x0D, 0x27, 0x3B, (byte) 0xEE};
    private static String ADDRESS_TEXT = "16UwLL9Risc3QfPqBUvKofHmBQ7wMtjvM";
    private static String BROKEN_ADDRESS_TEXT = "16UwLl9Risc3QfPqBUvKofHmBQ7wMtjvM";

    // Test cases from https://github.com/bitcoin/bitcoin/blob/master/src/test/base58_tests.cpp
    @Before
    public void initialize() {
        _testCases.add(new Tuple<String, byte[]>("", new byte[]{}));
        _testCases.add(new Tuple<String, byte[]>("1112", new byte[]{0x00, 0x00, 0x00, 0x01}));
        _testCases.add(new Tuple<String, byte[]>("2g", new byte[]{0x61}));
        _testCases.add(new Tuple<String, byte[]>("a3gV", new byte[]{0x62, 0x62, 0x62}));
        _testCases.add(new Tuple<String, byte[]>("aPEr", new byte[]{0x63, 0x63, 0x63}));
        _testCases.add(new Tuple<String, byte[]>("2cFupjhnEsSn59qHXstmK2ffpLv2", new byte[]{0x73, 0x69, 0x6d, 0x70, 0x6c, 0x79, 0x20, 0x61, 0x20, 0x6c, 0x6f, 0x6e, 0x67, 0x20, 0x73, 0x74, 0x72, 0x69, 0x6e, 0x67}));
        _testCases.add(new Tuple<String, byte[]>("1NS17iag9jJgTHD1VXjvLCEnZuQ3rJDE9L", new byte[]{0x00, (byte) 0xeb, 0x15, 0x23, 0x1d, (byte) 0xfc, (byte) 0xeb, 0x60, (byte) 0x92, 0x58, (byte) 0x86, (byte) 0xb6, 0x7d, 0x06, 0x52, (byte) 0x99, (byte) 0x92, 0x59, 0x15, (byte) 0xae, (byte) 0xb1, 0x72, (byte) 0xc0, 0x66, 0x47}));
        _testCases.add(new Tuple<String, byte[]>("ABnLTmg", new byte[]{0x51, 0x6b, 0x6f, (byte) 0xcd, 0x0f}));
        _testCases.add(new Tuple<String, byte[]>("3SEo3LWLoPntC", new byte[]{(byte) 0xbf, 0x4f, (byte) 0x89, 0x00, 0x1e, 0x67, 0x02, 0x74, (byte) 0xdd}));
        _testCases.add(new Tuple<String, byte[]>("3EFU7m", new byte[]{0x57, 0x2e, 0x47, (byte) 0x94}));
        _testCases.add(new Tuple<String, byte[]>("EJDM8drfXA6uyA", new byte[]{(byte) 0xec, (byte) 0xac, (byte) 0x89, (byte) 0xca, (byte) 0xd9, 0x39, 0x23, (byte) 0xc0, 0x23, 0x21}));
        _testCases.add(new Tuple<String, byte[]>("Rt5zm", new byte[]{0x10, (byte) 0xc8, 0x51, 0x1e}));
        _testCases.add(new Tuple<String, byte[]>("1111111111", new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00}));
    }

    @Test
    public void canEncodeToBase58() throws NoSuchAlgorithmException {
        for (Tuple<String, byte[]> test : _testCases) {
            byte[] bytes = test.item2;
            String expected = test.item1;

            String encoded = Base58Check.encodePlain(bytes);

            Assert.assertEquals(expected, encoded);
        }
    }

    @Test
    public void canDecodeFromBase58() throws NoSuchAlgorithmException, AddressFormatException {

        for (Tuple<String, byte[]> test : _testCases) {
            byte[] expected = test.item2;
            String text = test.item1;

            byte[] decoded = Base58Check.decodePlain(text);

            Assert.assertTrue(Arrays.equals(decoded, expected));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void DecodeInvalidChar()
    {
        Base58Check.decodePlain("ab0");
    }

    @Test
    public void EncodeBitcoinAddress() throws NoSuchAlgorithmException {
        String actualText = Base58Check.encode(ADDRESS_BYTES);
        Assert.assertEquals(ADDRESS_TEXT, actualText);
    }

    @Test
    public void DecodeBitcoinAddress() throws NoSuchAlgorithmException {
        byte[] actualBytes = Base58Check.decode(ADDRESS_TEXT);
        Assert.assertTrue(Arrays.equals(actualBytes, ADDRESS_BYTES));
    }

    @Test(expected = IllegalArgumentException.class)
    public void DecodeBrokenBitcoinAddress() throws NoSuchAlgorithmException {
        byte[] actualBytes = Base58Check.decode(BROKEN_ADDRESS_TEXT);
        Assert.assertTrue(Arrays.equals(actualBytes, ADDRESS_BYTES));
    }
}
