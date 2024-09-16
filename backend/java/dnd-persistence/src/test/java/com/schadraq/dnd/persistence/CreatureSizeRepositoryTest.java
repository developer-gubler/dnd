package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@DataJpaTest(properties = {"spring.main.web-application-type=none","spring.sql.init.continue-on-error=true"})
//@ContextConfiguration(classes = {CreatureSize.class,CreatureSizeRepository.class})
//@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
//@EntityScan("com.schadraq.dnd.persistence")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DndPersistenceApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@Sql(scripts = {"/data-h2.sql"})
@Disabled
@Slf4j
public class CreatureSizeRepositoryTest extends PersistenceTest {

	@Autowired
	private CreatureSizeRepository repo;

    private CreatureSize testObject;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method test
    	testObject = new CreatureSize();
    }

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(true, repo, UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388f"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature Size: " + i.getName());
	    		return Mono.just(i);
			});
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(false, repo, UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature Size: " + i.getName());
	    		return Mono.just(i);
			});
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	createRecord(false, repo, new CreatureSize(UUID.randomUUID(), "colossal", BigDecimal.valueOf(30L)))
			.flatMap(i -> {
	    		log.info("Creature Size: " + i.getName());

	    		return readRecord(true, repo, i, (found) -> {assertEquals(i.getName(), found.getName());assertEquals(i.getSpace().shortValue(), found.getSpace().shortValue());} );
			});
    }
}
