package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.schadraq.dnd.DndPersistenceApplication;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndPersistenceApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Disabled
@Slf4j
public class ChallengeRatingMockMvcTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ChallengeRatingRepository repo;

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		ChallengeRating record = readRecord(true, repo, UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b"), (found) -> {});
    	if (record != null) {
    		log.info("Challenge Rating: " + record.getCr());
    	}
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		ChallengeRating record = readRecord(false, repo, UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453"), (found) -> {});
    	if (record != null) {
    		log.info("Challenge Rating: " + record.getCr());
    	}
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	ChallengeRating record = createRecord(false, repo, new ChallengeRating(UUID.randomUUID(), BigDecimal.valueOf(31L), 175000L));
    	if (record != null) {
    		readRecord(true, repo, record, (found) -> {assertEquals(record.getCr().shortValue(), found.getCr().shortValue());assertEquals(record.getExperience(), found.getExperience());} );
    	}
    }
}