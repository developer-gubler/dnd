package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.schadraq.dnd.DndPersistenceApplication;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@DataJpaTest
@ContextConfiguration(classes = {CreatureFamily.class,CreatureFamilyRepository.class})
@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
@EntityScan("com.schadraq.dnd.persistence")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DndPersistenceApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@Disabled
@Slf4j
public class CreatureFamilyRepositoryTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CreatureFamilyRepository repo;

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
