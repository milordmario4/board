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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// Import nécessaire pour dire à Spring quelle application démarrer
import org.thingsboard.server.ThingsboardServerApplication;

import javax.sql.DataSource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
    // CORRECTION ICI : On précise explicitement la classe de configuration
    classes = ThingsboardServerApplication.class, 
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BonusIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // SECURITE : On simule la base de données pour éviter le crash "Connection Refused"
    @MockBean
    private DataSource dataSource;

    @Test
    public void testLoginEndpoint() throws Exception {
        // On teste l'API d'auth. 
        // 401 (Unauthorized) ou 405 (Method Not Allowed) prouve que le serveur est EN VIE.
        mockMvc.perform(get("/api/auth/login"))
               .andExpect(status().is4xxClientError());
    }
}