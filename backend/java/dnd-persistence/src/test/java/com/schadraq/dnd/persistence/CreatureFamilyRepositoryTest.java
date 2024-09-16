package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
//@ContextConfiguration(classes = {CreatureFamily.class,CreatureFamilyRepository.class})
//@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
//@EntityScan("com.schadraq.dnd.persistence")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DndPersistenceApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@Sql(scripts = {"/data-h2.sql"})
@Disabled
@Slf4j
public class CreatureFamilyRepositoryTest extends PersistenceTest {

	@Autowired
	private CreatureFamilyRepository repo;

    private CreatureFamily testObject;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method test
    	testObject = new CreatureFamily();
    }

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(true, repo, UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad4"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature Family: " + i.getName());
	    		return Mono.just(i);
			});
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(false, repo, UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature Family: " + i.getName());
	    		return Mono.just(i);
			});
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(true, repo, UUID.fromString("7f74e64f-f097-41d1-8f4a-d1e2db6bf46f"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature Family: " + i.getName());

	            ///////////////////////////////////////////////////////////////////////
	            // NOTE: Test to see if we can insert a new alignment
	        	return createRecord(false, repo, new CreatureFamily(UUID.randomUUID(), i.getClassificationId(), "Gubler"))
	    			.flatMap(i2 -> {
	    	    		readRecord(true, repo, i2, (found) -> {assertEquals(i2.getName(), found.getName());assertEquals(i2.getClassificationId(), found.getClassificationId());} );
	    	    		return Mono.just(i2);
	    			});
			});
    }
}
