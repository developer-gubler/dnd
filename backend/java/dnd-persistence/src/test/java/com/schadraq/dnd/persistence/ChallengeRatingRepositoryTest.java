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
//@ContextConfiguration(classes = {ChallengeRating.class,ChallengeRatingRepository.class})
//@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
//@EntityScan("com.schadraq.dnd.persistence")
//@SpringBootTest(classes = {ChallengeRatingRepository.class})
//@AutoConfigureTestDatabase
//@ContextConfiguration(classes = {ChallengeRatingRepository.class})
//@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
//@EntityScan("com.schadraq.dnd.persistence")
@Sql(scripts = {"/data-h2.sql"})
@Disabled
@Slf4j
public class ChallengeRatingRepositoryTest extends PersistenceTest {

	@Autowired
	private ChallengeRatingRepository repo;

    private ChallengeRating testObject;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method test
    	testObject = new ChallengeRating();
    }

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(true, repo, UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Challenge Rating: " + i.getCr());
	    		return Mono.just(i);
			});
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(false, repo, UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Challenge Rating: " + i.getCr());
	    		return Mono.just(i);
			});
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	createRecord(false, repo, new ChallengeRating(UUID.randomUUID(), BigDecimal.valueOf(31L), 175000L))
    		.flatMap(i -> {
        		return readRecord(true, repo, i, (found) -> {assertEquals(i.getCr().shortValue(), i.getCr().shortValue());assertEquals(i.getExperience(), i.getExperience());} );
    		});
    }
}