package com.bootcamp.playapi;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by raviks on 4/15/16.
 */
public class PlayApiTest {

    @Test
    public void testGetDataFromPlayApiWhenInputIsLessThanTen() throws IOException {
        PlayApi playApi = new PlayApi(new HttpClientStub());
        int expectedOutput = 2;
        int actualOutput = playApi.getDataFromPlayApi(1);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetDataFromPlayApiWhenInputIsGreaterThanTen() throws IOException {
        PlayApi playApi = new PlayApi(new HttpClientStub());
        int expectedOutput = 22;
        int actualOutput = playApi.getDataFromPlayApi(11);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetDataFromPlayApiWhenInputIsGreaterThanTenWithApacheHttpClient() throws IOException {
        PlayApi playApi = new PlayApi(HttpClientBuilder.create().bui ld());
        int expectedOutput = 22;
        int actualOutput = playApi.getDataFromPlayApi(11);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetDataFromPlayApiWhenInputIsLessThanTenWithApacheHttpClient() throws IOException {
        PlayApi playApi = new PlayApi(HttpClientBuilder.create().build());
        int expectedOutput = 2;
        int actualOutput = playApi.getDataFromPlayApi(1);
        assertEquals(expectedOutput, actualOutput);
    }
}