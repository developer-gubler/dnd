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
@ContextConfiguration(classes = {CreatureTemplate.class,CreatureTemplateRepository.class})
@EnableJpaRepositories(basePackages = {"com.schadraq.dnd.persistence.*"})
@EntityScan("com.schadraq.dnd.persistence")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DndPersistenceApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@Disabled
@Slf4j
public class CreatureTemplateRepositoryTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CreatureTemplateRepository repo;

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(true, repo, UUID.fromString("5091265c-1645-47f2-8f1f-381b899085ad"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature: " + i.getName());
	    		return Mono.just(i);
			});
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		readRecord(false, repo, UUID.fromString("5091265c-1645-47f2-8f1f-381b899085a"), (found) -> {})
			.flatMap(i -> {
	    		log.info("Creature: " + i.getName());
	    		return Mono.just(i);
			});
	}

    @Test
    public void test_add_valid_record() {

		readRecord(true, repo, UUID.fromString("9aa2a9f8-27a7-4797-87c8-2887f8b79d60"), (found) -> {})
			.flatMap(berserker -> {
	    		log.info("Creature: " + berserker.getName());

	    		///////////////////////////////////////////////////////////////////////
	            // NOTE: Test to see if we can insert a new alignment
//	    		ChallengeRating cr = berserker.getCr();
//	    		CreatureSize size = berserker.getSize();
//	    		CreatureFamily family = berserker.getFamily();
	    		CreatureTemplate c = new CreatureTemplate(UUID.randomUUID(), "Special Orc", berserker.getFamilyId(), berserker.getSizeId(), "CG", (short)40, (short)0, (short)0, (short)0, (short)0,
	    				(short)19, (short)8, (short)16, (short)5, (short)7, (short)7, (short)59, "7d10 + 21", (short)11, (short)2,
	    				berserker.getChallengeRatingId(), false, false, false, false, false, false, "none", "none", "none",
	    				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
	    				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
	    				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
	    				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none");

	    		return createRecord(false, repo, c)
					.flatMap(i -> {
			    		log.info("Creature: " + i.getName());
		        		return readRecord(true, repo, i, (found) -> {assertEquals(i.getName(), found.getName());assertEquals(i.getFamilyId(), found.getFamilyId());} );
					});
			});
    }
}
