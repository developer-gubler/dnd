package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.schadraq.dnd.DndPersistenceApplication;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@DataJpaTest
@ContextConfiguration(classes = {ChallengeRating.class,ChallengeRatingRepository.class})
@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
@EntityScan("com.schadraq.dnd.persistence")
//@SpringBootTest(classes = {ChallengeRatingRepository.class})
//@AutoConfigureTestDatabase
//@ContextConfiguration(classes = {ChallengeRatingRepository.class})
//@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
//@EntityScan("com.schadraq.dnd.persistence")
@Disabled
@Slf4j
public class ChallengeRatingRepositoryTest extends PersistenceTest {

	@Autowired
	private ChallengeRatingRepository repo;

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