package com.schadraq.dnd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.schadraq.dnd.CreatureController;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: https://spring.io/guides/gs/testing-web
 * 
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the H2 settings and comment out thePostgreSQL  settings.
 * 
 * NOTE: The class level annotation @WebMvcTest, the @Autowired MockMvc, and
 *       the @Autowired BattleController
 * 
 * NOTE: Properties of this style of testing:
 * - Web Server is NOT started (ie Tomcat will be absent in the console log)
 *   due to the @AutoConfigureMockMvc annotation - also uses @Autowired MockMvc
 * - Processes the request as if there was a web server (ie just like a normal)
 * - All beans are auto-configured for us 
 * 
 * NOTE: This is probably my second favorite style of testing next to TestContainers.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiReaderApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Disabled
@Slf4j
public class CreatureControllerMockMvcTests {

	@Autowired
	private MockMvc mockMvc;

    @Autowired
    private CreatureController controller;

	@Test
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	void test_retrieve_challenge_ratings() throws Exception {
		this.mockMvc
			.perform(get("/api/dnd/creature/challenge-ratings"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("30")));
	}

	@Test
	void test_retrieve_creature_families() throws Exception {
		this.mockMvc
			.perform(get("/api/dnd/creature/families"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Aberration")));
	}

	@Test
	void test_retrieve_creature_sizes() throws Exception {
		this.mockMvc
			.perform(get("/dnd-battle/creature-sizes"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("gargantuan")));
	}

	@Test
	void test_retrieve_creatures() throws Exception {
		this.mockMvc
			.perform(get("/api/dnd/creature/templates"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Ogre")));
	}

	@Test
	void test_retrieve_valid_single_creature() throws Exception {
		this.mockMvc
			.perform(get("/api/dnd/creature/template").param("id", "5091265c-1645-47f2-8f1f-381b899085ad"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Ogre")));
	}

	@Test
	void test_retrieve_invalid_single_creature() throws Exception {
		this.mockMvc
			.perform(get("/api/dnd/creature/template").param("id", "5091265c-1645-47f2-8f1f-381b899085a"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("")));
	}
}
