package com.example;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;

import static com.example.Material.*;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class DwellingControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testIndex() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/dwelling").status());
    }

    @Test
    public void createBuilding() {
        var command = new CreateBuildingCommand("123 Market St", 1, 1, 100.00, "Elegant LLC", METAL);
        var req = HttpRequest.POST("/buildings", command);
        var res = client.toBlocking().exchange(req, Building.class);
        assertEquals(HttpStatus.OK, res.status());
    }
}
