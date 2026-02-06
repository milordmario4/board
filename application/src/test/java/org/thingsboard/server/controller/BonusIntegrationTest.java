/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test d'Aptitude Fonctionnelle (Functional Suitability)
 * Objectif : Vérifier que le système de sécurité répond correctement
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class BonusIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoginEndpoint() throws Exception {
        // On vérifie que l'endpoint de login répond
        // On s'attend à une erreur 4xx (probablement 405 Method Not Allowed 
        // ou 401 Unauthorized) car GET n'est pas la bonne méthode pour login
        mockMvc.perform(get("/api/auth/login"))
               .andExpect(status().is4xxClientError());
    }
}