package example.demo.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloControllerTest {
    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHello() {
        HttpRequest<String> request = HttpRequest.GET("/hello");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hell Chika", body);
    }
    @Test
    public void testSample() {
        HttpRequest<String> request = HttpRequest.GET("/sample");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("sample", body);
    }
}