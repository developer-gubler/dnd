package com.schadraq.dnd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.schadraq.dnd.CreatureController;
import com.schadraq.dnd.persistence.PersistenceTest;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the PostgreSQL settings and comment out the H2 settings.
 * 
 * NOTE: The class level annotation @Testcontainers, @Sql (init database), and
 * 		 the @Autowired BattleController
 * 
 * NOTE: Properties of this style of testing:
 * - Web Server is started (ie Tomcat will be in the console log)
 * - All beans are auto-configured for us 
 * - Starts a PostgreSQL database within a container - it is initialized by the
 * 	 @Sql annotation
 * 
 * NOTE: This is my favorite styles of testing because it imitates the actual
 * 		 production environment as much as possible.
 */
@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)			// NOTE: This is important because the results of test 3 are dependent on test 2 having put the value into the database.
@ActiveProfiles("test")
@Slf4j
public class CreatureControllerContainerTests extends PersistenceTest {

	@Container
	@ServiceConnection
	private static PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
																	.withDatabaseName("dnd-database")
																	.withUsername("dnd-user")
																	.withPassword("dnd-secret")
																	.withExposedPorts(5432);

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private CreatureController controller;

	@Test
	@Order(1)
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	void test_retrieve_challenge_ratings() throws Exception {

//		readRecord(true, repo, UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b"), (found) -> {});
//
//		readRecord(true, repo, UUID.fromString("40e26256-dac8-4834-a055-62d9457dc908"), (found) -> {});

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/challenge-ratingss",String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/challenge-ratings",
				String.class)).contains("30");
	}

	@Test
	void test_retrieve_creature_classifications() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/classifications", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/classifications",
				String.class)).contains("Monstrosity");
	}

	@Test
	void test_retrieve_creature_families() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/families", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/families",
				String.class)).contains("Titan");
	}

	@Test
	void test_retrieve_creature_sizes() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/sizes", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/sizes",
				String.class)).contains("gargantuan");
	}

	@Test
	void test_retrieve_creatures() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/templates", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/templates",
				String.class)).contains("Ogre");
	}

	@Test
	void test_retrieve_valid_single_creature() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?creature_id=5091265c-1645-47f2-8f1f-381b899085ad", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?creature_id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("Ogre");
	}

	@Test
	void test_retrieve_invalid_single_creature() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?creature_id=5091265c-1645-47f2-8f1f-381b899085a", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/creature/template?creature_id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).isNull();
	}
}
