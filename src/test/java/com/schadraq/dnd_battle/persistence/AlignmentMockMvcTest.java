package com.schadraq.dnd_battle.persistence;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.schadraq.dnd_battle.BattleController;
import com.schadraq.dnd_battle.DndBattleApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the H2 settings and comment out thePostgreSQL  settings.
 * 
 * NOTE: This test class does NOT start the web server and processes the
 * request just like a normal request would. Tomcat will be absent in the
 * console log.
 * 
 * NOTE: This is probably my favorite style of testing.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndBattleApplication.class)	//  NOTE: tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
public class AlignmentMockMvcTest extends PersistenceTest {

	@Autowired
	private MockMvc mockMvc;

    @Autowired
    private AlignmentRepository alignmentRepository;

    @Autowired
    private BattleController controller;

	@Test
	void contextLoads() throws Exception {

		///////////////////////////////////////////////////////////////////////
		// NOTE: Sanity check - fail if the application context cannot start
		assertThat(controller).isNotNull();
	}

	@Test
	void testAlignmentWebLayer() throws Exception {
		this.mockMvc
			.perform(get("/dnd-battle/alignments"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("unaligned")));
	}

    @Test
    public void testAlignmentModelLayer() {

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can retrieve an alignment
    	Alignment alignment = readRecord(alignmentRepository, 1L, (found) -> {});
    	if (alignment != null) {
    		log.info("alignment name: " + alignment.getName());
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert a new alignment
    	Alignment a = createRecord(false, alignmentRepository, new Alignment(ALIGNMENT_NAME, ALIGNMENT_ABBR, ALIGNMENT_DESCRIPTION));
    	if (a != null) {
    		readRecord(alignmentRepository, a, (found) -> {assertEquals(a.getName(), found.getName());assertEquals(a.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same abbr
    	Alignment b = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME + "1", ALIGNMENT_ABBR, ALIGNMENT_DESCRIPTION + "1"));
    	if (b != null) {
    		readRecord(alignmentRepository, b.getId(), (found) -> {assertEquals(b.getName(), found.getName());assertEquals(b.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same name
    	Alignment c = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME, ALIGNMENT_ABBR + "1", ALIGNMENT_DESCRIPTION + "1"));
    	if (c != null) {
    		readRecord(alignmentRepository, c.getId(), (found) -> {assertEquals(c.getName(), found.getName());assertEquals(c.getAbbr(), found.getAbbr());} );
    	}

        ///////////////////////////////////////////////////////////////////////
        // NOTE: Test to see if we can insert an alignment with the same desc
    	Alignment d = createRecord(true, alignmentRepository, new Alignment(ALIGNMENT_NAME + "1", ALIGNMENT_ABBR + "1", ALIGNMENT_DESCRIPTION));
    	if (d != null) {
    		readRecord(alignmentRepository, d.getId(), (found) -> {assertEquals(d.getName(), found.getName());assertEquals(d.getAbbr(), found.getAbbr());} );
    	}
    }
}
