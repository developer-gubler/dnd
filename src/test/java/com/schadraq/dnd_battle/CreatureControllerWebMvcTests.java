package com.schadraq.dnd_battle;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import com.schadraq.dnd_battle.persistence.ChallengeRating;
import com.schadraq.dnd_battle.persistence.ChallengeRatingRepository;
import com.schadraq.dnd_battle.persistence.CreatureTemplate;
import com.schadraq.dnd_battle.persistence.CreatureClassification;
import com.schadraq.dnd_battle.persistence.CreatureClassificationRepository;
import com.schadraq.dnd_battle.persistence.CreatureFamily;
import com.schadraq.dnd_battle.persistence.CreatureFamilyRepository;
import com.schadraq.dnd_battle.persistence.CreatureTemplateRepository;
import com.schadraq.dnd_battle.persistence.CreatureSize;
import com.schadraq.dnd_battle.persistence.CreatureSizeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: https://spring.io/guides/gs/testing-web
 * 
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the H2 settings and comment out thePostgreSQL settings.
 * 
 * NOTE: The class level annotation @WebMvcTest (narrow the tests to only the
 * 		 web layer), the @Autowired MockMvc, and the field level @MockBeans.
 *       Also, note @SpringBootTest does NOT exist.
 * 
 * NOTE: Properties of this style of testing:
 * - Web Server is NOT started (ie Tomcat will be absent in the console log)
 * - Processes the request as if there was a web server (ie just like a normal)
 * - No beans are auto-configured for us. We must "mock" the responses prior
 * 	 to using beans via Mockito.
 *  
 * NOTE: I am not fond of this style of testing because it requires making your
 * own beans and mocking their responses -- which could be wrong, especially
 * over time (ie. software changes and so do possible responses) and could
 * require high maintenance over time.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CreatureController.class)
@ActiveProfiles("test")
@Slf4j
public class CreatureControllerWebMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChallengeRatingRepository repoChallengeRating;

	@MockBean
	private CreatureClassificationRepository repoCreatureClassification;

	@MockBean
	private CreatureFamilyRepository repoCreatureFamily;

	@MockBean
	private CreatureSizeRepository repoCreatureSize;

	@MockBean
	private CreatureTemplateRepository repoCreature;

	@Test
	void test_retrieve_challenge_ratings() throws Exception {
		when(repoChallengeRating.findAll())
			.thenReturn(Arrays.asList(new ChallengeRating(UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b"), BigDecimal.valueOf(0.5), 100L), new ChallengeRating(UUID.fromString("40e26256-dac8-4834-a055-62d9457dc908"), BigDecimal.valueOf(1), 200L)));
		this.mockMvc
			.perform(get("/dnd-battle/challenge-ratings"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("1")));
	}

	@Test
	void test_retrieve_creature_families() throws Exception {
		CreatureClassification classHumanoid = new CreatureClassification(UUID.fromString("20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12"),"Humanoid");
		CreatureClassification classGiant = new CreatureClassification(UUID.fromString("dc575e25-a4aa-4ad8-9dca-0c79aa5e0e67"),"Giant");
		when(repoCreatureFamily.findAll())
			.thenReturn(Arrays.asList(new CreatureFamily(UUID.fromString("7f74e64f-f097-41d1-8f4a-d1e2db6bf46f"), classHumanoid, "Orc"), new CreatureFamily(UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad4"), classGiant, "-")));
		this.mockMvc
			.perform(get("/dnd-battle/creature-families"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Orc")));
	}

	@Test
	void test_retrieve_creature_sizes() throws Exception {
		when(repoCreatureSize.findAll())
			.thenReturn(Arrays.asList(new CreatureSize(UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388f"), "large", BigDecimal.valueOf(10)), new CreatureSize(UUID.fromString("4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f"), "medium", BigDecimal.valueOf(5))));
		this.mockMvc
			.perform(get("/dnd-battle/creature-sizes"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("large")));
	}

	@Test
	void test_retrieve_creatures() throws Exception {
		ChallengeRating crOrc = new ChallengeRating(UUID.fromString("f8d4ed21-b84c-4c7a-9e8d-be77e3b7453b"), BigDecimal.valueOf(0.5), 100L);
		ChallengeRating crOgre = new ChallengeRating(UUID.fromString("124080f8-c2fd-4896-b2af-4d112f67649a"), BigDecimal.valueOf(2), 450L);
		CreatureSize sizeLarge = new CreatureSize(UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388f"), "large", BigDecimal.valueOf(10));
		CreatureSize sizeMedium = new CreatureSize(UUID.fromString("4a3b4de4-acfb-45dc-84e4-8efc63e5ee2f"), "medium", BigDecimal.valueOf(5));
		CreatureClassification classHumanoid = new CreatureClassification(UUID.fromString("20f1d28a-06ca-41c9-b2b5-88dd9cc9fb12"),"Humanoid");
		CreatureClassification classGiant = new CreatureClassification(UUID.fromString("dc575e25-a4aa-4ad8-9dca-0c79aa5e0e67"),"Giant");
		CreatureFamily familyOrc = new CreatureFamily(UUID.fromString("7f74e64f-f097-41d1-8f4a-d1e2db6bf46f"), classHumanoid, "Orc");
		CreatureFamily familyGiant = new CreatureFamily(UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad4"), classGiant, "-");
		CreatureTemplate orc = new CreatureTemplate(UUID.fromString("05808cc6-637e-4d49-a396-a6e2af138664"), "Orc", familyOrc, sizeMedium, "CE", (short)30, (short)0, (short)0, (short)0, (short)0,
				(short)16, (short)12, (short)16, (short)9, (short)13, (short)12, (short)15, "2d8 + 6", (short)13, (short)2,
				crOrc, false, false, false, false, false, false, "none", "none", "none",
				"none", "none", "none", "none", "proficient", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none");
		CreatureTemplate ogre = new CreatureTemplate(UUID.fromString("5091265c-1645-47f2-8f1f-381b899085ad"), "Ogre", familyGiant, sizeLarge, "CE", (short)40, (short)0, (short)0, (short)0, (short)0,
				(short)19, (short)8, (short)16, (short)5, (short)7, (short)7, (short)59, "7d10 + 21", (short)11, (short)2,
				crOgre, false, false, false, false, false, false, "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none");
		when(repoCreature.findAll())
			.thenReturn(Arrays.asList(orc, ogre));
		this.mockMvc
			.perform(get("/dnd-battle/creature-templates"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Ogre")));
	}

	@Test
	void test_retrieve_valid_single_creature() throws Exception {
		ChallengeRating crOgre = new ChallengeRating(UUID.fromString("124080f8-c2fd-4896-b2af-4d112f67649a"), BigDecimal.valueOf(2), 450L);
		CreatureSize sizeLarge = new CreatureSize(UUID.fromString("7ce51487-ad83-49cb-8953-8378fb6d388f"), "large", BigDecimal.valueOf(10));
		CreatureClassification classGiant = new CreatureClassification(UUID.fromString("dc575e25-a4aa-4ad8-9dca-0c79aa5e0e67"),"Giant");
		CreatureFamily familyGiant = new CreatureFamily(UUID.fromString("60e77f04-3ab2-4494-9469-73c26d2aaad4"), classGiant, "-");
		CreatureTemplate ogre = new CreatureTemplate(UUID.fromString("5091265c-1645-47f2-8f1f-381b899085ad"), "Ogre", familyGiant, sizeLarge, "CE", (short)40, (short)0, (short)0, (short)0, (short)0,
				(short)19, (short)8, (short)16, (short)5, (short)7, (short)7, (short)59, "7d10 + 21", (short)11, (short)2,
				crOgre, false, false, false, false, false, false, "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none",
				"none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none");
		when(repoCreature.findById(UUID.fromString("5091265c-1645-47f2-8f1f-381b899085ad")))
			.thenReturn(Optional.of(ogre));
		this.mockMvc
			.perform(get("/dnd-battle/creature-template?id=5091265c-1645-47f2-8f1f-381b899085ad"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Ogre")));
	}

//	@Test
//	void test_retrieve_invalid_single_creature() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/dnd-battle/creature?id=5091265c-1645-47f2-8f1f-381b899085a",
//				String.class)).contains("");
//	}

}
