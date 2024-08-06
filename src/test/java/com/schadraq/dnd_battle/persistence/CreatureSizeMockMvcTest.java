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

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.schadraq.dnd_battle.BattleController;
import com.schadraq.dnd_battle.DndBattleApplication;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndBattleApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
public class CreatureSizeMockMvcTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CreatureSizeRepository repo;

    @Autowired
    private BattleController controller;

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
		CreatureSize record = readRecord(true, repo, UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388f"), (found) -> {});
    	if (record != null) {
    		log.info("Creature Size: " + record.getName());
    	}
	}

	@Test
	public void test_retrieve_invalid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve a record
		CreatureSize record = readRecord(false, repo, UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388"), (found) -> {});
    	if (record != null) {
    		log.info("Creature Size: " + record.getName());
    	}
	}

    @Test
    public void test_add_valid_record() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	CreatureSize record = createRecord(false, repo, new CreatureSize(UUID.randomUUID(), "colossal", BigDecimal.valueOf(30L)));
    	if (record != null) {
    		readRecord(true, repo, record, (found) -> {assertEquals(record.getName(), found.getName());assertEquals(record.getSpace().shortValue(), found.getSpace().shortValue());} );
    	}
    }
}
