package com.schadraq.dnd_battle.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.schadraq.dnd_battle.CreatureController;
import com.schadraq.dnd_battle.DndBattleApplication;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndBattleApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Disabled
@Slf4j
public class CreatureMockMvcTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CreatureTemplateRepository repo;

    @Autowired
    private CreatureController controller;

	@Test
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	public void test_retrieve_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureTemplate record = readRecord(true, repo, UUID.fromString("5091265c-1645-47f2-8f1f-381b899085ad"), (found) -> {});
    	if (record != null) {
    		log.info("Creature: " + record.getName());
    	}
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureTemplate record = readRecord(false, repo, UUID.fromString("5091265c-1645-47f2-8f1f-381b899085a"), (found) -> {});
    	if (record != null) {
    		log.info("Creature: " + record.getName());
    	}
	}

    @Test
    public void test_add_valid_record() {

		CreatureTemplate berserker = readRecord(true, repo, UUID.fromString("9aa2a9f8-27a7-4797-87c8-2887f8b79d60"), (found) -> {});

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
//		ChallengeRating cr = berserker.getCr();
//		CreatureSize size = berserker.getSize();
//		CreatureFamily family = berserker.getFamily();
		CreatureTemplate c = new CreatureTemplate(UUID.randomUUID(), "Special Orc", berserker.getFamilyId(), berserker.getSizeId(), "CG", (short)40, (short)0, (short)0, (short)0, (short)0,
				(short)19, (short)8, (short)16, (short)5, (short)7, (short)7, (short)59, "7d10 + 21", (short)11, (short)2,
				berserker.getChallengeRatingId(), false, false, false, false, false, false, "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none");
    	CreatureTemplate record = createRecord(false, repo, c);
    	if (record != null) {
    		readRecord(true, repo, record, (found) -> {assertEquals(record.getName(), found.getName());assertEquals(record.getFamilyId(), found.getFamilyId());} );
    	}
    }
}
