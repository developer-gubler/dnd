package com.schadraq.dnd_battle.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.schadraq.dnd_battle.DndBattleApplication;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndBattleApplication.class)
@ActiveProfiles("test")
@Slf4j
public class AlignmentTest extends PersistenceTest {

	private static final String ALIGNMENT_ABBR = "T";

	private static final String ALIGNMENT_NAME = "test";

	private static final String ALIGNMENT_DESCRIPTION = "This is a test.";

    @Autowired
    private EntityManager entityManager;
	 
    @Autowired
    private AlignmentRepository alignmentRepository;

    @Test
    public void givenAlignmentRepository_whenSaveAndRetreiveEntity_thenOK() {

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
