package org.thingsboard.server.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BonusIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test de l'endpoint de login.
     * Vérifie que l'endpoint répond avec un statut OK (200) ou Unauthorized (401),
     * mais jamais avec un 404 ou 500.
     */
    @Test
    public void testLoginEndpoint() throws Exception {
        mockMvc.perform(get("/api/noauth/login"))
                .andExpect(
                        org.hamcrest.Matchers.either(status().isOk())
                                .or(status().isUnauthorized())
                );
    }

    /**
     * Test de l'endpoint Swagger UI.
     * Vérifie que la documentation Swagger est accessible et renvoie un statut OK (200).
     */
    @Test
    public void testSwaggerUIEndpoint() throws Exception {
        mockMvc.perform(get("/swagger-ui.html"))
                .andExpect(status().isOk());
    }
}
