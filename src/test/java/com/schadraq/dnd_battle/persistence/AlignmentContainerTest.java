package com.schadraq.dnd_battle.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.schadraq.dnd_battle.BattleController;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the PostgreSQL settings and comment out the H2 settings.
 */
@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)			// NOTE: This is important because the results of test 3 are dependent on test 2 having put the value into the database.
@ActiveProfiles("test")
@Slf4j
public class AlignmentContainerTest extends PersistenceTest {

	private static final String ALIGNMENT_ABBR = "T";

	private static final String ALIGNMENT_NAME = "test";

	private static final String ALIGNMENT_DESCRIPTION = "This is a test.";

	@Container
	@ServiceConnection
	private static PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
																	.withDatabaseName("dnd-database")
																	.withUsername("dnd-user")
																	.withPassword("dnd-secret");

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private AlignmentRepository alignmentRepository;

    @Autowired
    private BattleController controller;

	@Test
	@Order(1)
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	@Order(2)
	void testAlignmentWebLayer() throws Exception {
		Alignment a = createRecord(false, alignmentRepository, new Alignment("unaligned","U","Does not make moral or ethical choices, but rather acts on instinct."));
		if (a != null) {
			log.info("name: " + a.getName());
	    	readRecord(alignmentRepository, a, (found) -> {});
		}
		log.info(this.restTemplate.getForObject("http://localhost:" + port + "/dnd-battle/alignments",String.class));
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/dnd-battle/alignments",
				String.class)).contains("unaligned");
	}

    @Test
	@Order(3)
    void testAlignmentModelLayer() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test the retrieval of the record from previous test.
    	Alignment alignment = readRecord(alignmentRepository, 1L, (found) -> {});
    	if (alignment != null) {
    		log.info("alignment name: " + alignment.getName());
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	Alignment a = createRecord(false, alignmentRepository, new Alignment(ALIGNMENT_NAME, ALIGNMENT_ABBR, ALIGNMENT_DESCRIPTION));
    	if (a != null) {
    		readRecord(alignmentRepository, a, (found) -> {assertEquals(a.getName(), found.getName());assertEquals(a.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same abbr
    	Alignment b = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME + "1", ALIGNMENT_ABBR, ALIGNMENT_DESCRIPTION + "1"));
    	if (b != null) {
    		readRecord(alignmentRepository, b.getId(), (found) -> {assertEquals(b.getName(), found.getName());assertEquals(b.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same name
    	Alignment c = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME, ALIGNMENT_ABBR + "1", ALIGNMENT_DESCRIPTION + "1"));
    	if (c != null) {
    		readRecord(alignmentRepository, c.getId(), (found) -> {assertEquals(c.getName(), found.getName());assertEquals(c.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same desc
    	Alignment d = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME + "1", ALIGNMENT_ABBR + "1", ALIGNMENT_DESCRIPTION));
    	if (d != null) {
    		readRecord(alignmentRepository, d.getId(), (found) -> {assertEquals(d.getName(), found.getName());assertEquals(d.getAbbr(), found.getAbbr());} );
    	}
    }
}
