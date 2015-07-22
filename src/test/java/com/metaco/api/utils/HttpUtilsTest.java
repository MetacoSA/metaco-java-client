package com.metaco.api.utils;

import junit.framework.Assert;
import org.junit.Test;

public class HttpUtilsTest {
    @Test
    public void utilsCanDetectInvalidStatusCode() {
        Assert.assertFalse(HttpUtils.IsSuccessStatusCode(100));
        Assert.assertFalse(HttpUtils.IsSuccessStatusCode(300));
        Assert.assertFalse(HttpUtils.IsSuccessStatusCode(400));
        Assert.assertFalse(HttpUtils.IsSuccessStatusCode(500));
    }
    @Test
    public void utilsCanDetectValidStatusCode() {
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(200));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(201));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(202));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(203));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(204));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(205));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(206));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(207));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(210));
        Assert.assertTrue(HttpUtils.IsSuccessStatusCode(226));
    }
}
