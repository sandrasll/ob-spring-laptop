package com.example.laptopsesiones456.controller;

import com.example.laptopsesiones456.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar findAll  desde controladores Spring REST")
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response  =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @DisplayName("Comprobar findOneById  desde controladores Spring REST")
    @Test
    void findOneById() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/api/laptops/8", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @DisplayName("Comprobar create desde controladores Spring REST")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                {
                            "marca": "Laptop creado desde Spring Test",
                            "procesador": "intelcore3",
                            "ram": 8,
                            "velocprocesador": 2.4,
                            "capacidad": 512,
                            "fechafabricacion": "2022-03-11"
                        
                 }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals("Laptop creado desde Spring Test", result.getMarca());
        assertEquals(8, result.getRam());
        assertEquals(512, result.getCapacidad());
    }
}