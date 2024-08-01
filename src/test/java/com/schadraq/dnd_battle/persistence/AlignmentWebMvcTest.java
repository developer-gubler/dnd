package com.schadraq.dnd_battle.persistence;

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

import java.util.Arrays;

import com.schadraq.dnd_battle.AlignmentService;
import com.schadraq.dnd_battle.BattleController;

import lombok.extern.slf4j.Slf4j;

/**
 * NOTE: It is important to update the application-test.properties to leverage
 * 		 the H2 settings and comment out thePostgreSQL  settings.
 * 
 * NOTE: This test class does NOT start the web server and processes the
 * request just like a normal request would. Tomcat will be absent in the
 * console log.  Additionally, it only creates the BattleController bean.
 * However, because this is a @WebMvcTest, it does NOT create any of the
 * supporting beans, thus, we must create the @MockBean for it. We use
 * @MockBean to create and inject a mock for the AlignmentService (if you do
 * not do so, the application context cannot start), and we set its
 * expectations using Mockito.
 * 
 * NOTE: I am not fond of this style of testing because it requires making your
 * own beans and mocking their responses -- which could be wrong, especially
 * over time  (ie. software changes and so do possible responses).
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BattleController.class)
@ActiveProfiles("test")
@Slf4j
public class AlignmentWebMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlignmentService service;

	@Test
	void testAlignmentWebLayer() throws Exception {
		when(service.getAlignments())
			.thenReturn(Arrays.asList(new Alignment("unaligned", "U", "Does not make moral or ethical choices, but rather acts on instinct."),new Alignment("lawful good", "LG", "Can be counted on to do the right thing as expected by society.")));
		this.mockMvc
			.perform(get("/dnd-battle/alignments"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("unaligned")));
	}

}
