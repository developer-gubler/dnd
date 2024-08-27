package com.schadraq.dnd_battle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: https://spring.io/guides/gs/testing-web
 * 
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the H2 settings and comment out thePostgreSQL settings.
 * 
 * NOTE: The class level annotation @SpringBootTest, missing @Autowired MockMvc,
 *       the @Autowired TestRestTemplate, and the @Autowired BattleController
 * 
 * NOTE: Properties of this style of testing:
 * - Web Server IS started (ie Tomcat will be in the console log)
 * - Processes the request normally
 * - All beans are auto-configured for us 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndBattleApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@ActiveProfiles("test")
@Disabled
@Slf4j
public class CreatureControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CreatureController controller;

	@Test
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	void test_retrieve_challenge_ratings() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/challenge-ratings",
				String.class)).contains("30");
	}

	@Test
	void test_retrieve_creature_families() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/families",
				String.class)).contains("Aberration");
	}

	@Test
	void test_retrieve_creature_sizes() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/sizes",
				String.class)).contains("gargantuan");
	}

	@Test
	void test_retrieve_creatures() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/templates",
				String.class)).contains("Ogre");
	}

	@Test
	void test_retrieve_valid_single_creature() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("Ogre");
	}

	@Test
	void test_retrieve_invalid_single_creature() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).contains("");
	}
}
