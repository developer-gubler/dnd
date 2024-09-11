package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class CreatureFamilyMockMvcTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CreatureFamilyRepository repo;

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureFamily record = readRecord(true, repo, UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad4"), (found) -> {});
    	if (record != null) {
    		log.info("Creature Family: " + record.getName());
    	}
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureFamily record = readRecord(false, repo, UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad"), (found) -> {});
    	if (record != null) {
    		log.info("Creature Family: " + record.getName());
    	}
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureFamily r = readRecord(true, repo, UUID.fromString("7f74e64f-f097-41d1-8f4a-d1e2db6bf46f"), (found) -> {});
    	if (r != null) {
    		log.info("Creature Family: " + r.getName());
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	CreatureFamily record = createRecord(false, repo, new CreatureFamily(UUID.randomUUID(), r.getClassificationId(), "Gubler"));
    	if (record != null) {
    		readRecord(true, repo, record, (found) -> {assertEquals(record.getName(), found.getName());assertEquals(record.getClassificationId(), found.getClassificationId());} );
    	}
    }
}
