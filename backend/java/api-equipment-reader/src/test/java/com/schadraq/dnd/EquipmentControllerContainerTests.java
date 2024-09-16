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

import com.schadraq.dnd.EquipmentController;

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
public class EquipmentControllerContainerTests {

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
    private EquipmentController controller;

	@Test
	@Order(1)
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	void test_retrieve_armor_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor-list", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor-list",
				String.class)).contains("Splint");
	}

	@Test
	void test_retrieve_valid_single_armor() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor?armor_id=90288164-c213-4680-98f8-0273072a71cf", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor?armor_id=90288164-c213-4680-98f8-0273072a71cf",
				String.class)).contains("Plate");
	}

	@Test
	void test_retrieve_invalid_single_armor() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor?armor_id=90288164-c213-4680-98f8-0273072a71c", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/armor?armor_id=90288164-c213-4680-98f8-0273072a71c",
				String.class)).isNull();
	}

	@Test
	void test_retrieve_weapon_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon-list", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon-list",
				String.class)).contains("Light Crossbow");
	}

	@Test
	void test_retrieve_valid_single_weapon() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon?weapon_id=d3b13c04-130a-4114-89b0-ca4ea6b5f276", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon?weapon_id=d3b13c04-130a-4114-89b0-ca4ea6b5f276",
				String.class)).contains("Battleaxe");
	}

	@Test
	void test_retrieve_invalid_single_weapon() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon?weapon_id=d3b13c04-130a-4114-89b0-ca4ea6b5f27", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/weapon?weapon_id=d3b13c04-130a-4114-89b0-ca4ea6b5f27",
				String.class)).isNull();
	}

	@Test
	void test_retrieve_valid_creature_armor_proficiency() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085ad", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("medium");
	}

	@Test
	void test_retrieve_invalid_creature_armor_proficiency() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085a", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).isNull();
	}

	@Test
	void test_retrieve_valid_creature_armor_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-list?creature_id=5091265c-1645-47f2-8f1f-381b899085ad", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-list?creature_id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("Hide");
	}

	@Test
	void test_retrieve_invalid_creature_armor_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-list?creature_id=5091265c-1645-47f2-8f1f-381b899085a", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-armor-list?creature_id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).contains("[]");
	}

	@Test
	void test_retrieve_valid_creature_weapon_proficiency() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085ad", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("Greatclub");
	}

	@Test
	void test_retrieve_invalid_creature_weapon_proficiency() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085a", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-proficiency?creature_id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).contains("[]");
	}

	@Test
	void test_retrieve_valid_creature_weapon_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-list?creature_id=5091265c-1645-47f2-8f1f-381b899085ad", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-list?creature_id=5091265c-1645-47f2-8f1f-381b899085ad",
				String.class)).contains("Javelin");
	}

	@Test
	void test_retrieve_invalid_creature_weapon_list() throws Exception {

		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-list?creature_id=5091265c-1645-47f2-8f1f-381b899085a", String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dnd/equipment/creature-weapon-list?creature_id=5091265c-1645-47f2-8f1f-381b899085a",
				String.class)).contains("[]");
	}
}
