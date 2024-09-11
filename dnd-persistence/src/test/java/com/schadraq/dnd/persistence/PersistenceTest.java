package com.schadraq.dnd.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.schadraq.dnd.persistence.BaseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersistenceTest {

	protected static final String ALIGNMENT_ABBR = "T";

	protected static final String ALIGNMENT_NAME = "test";

	protected static final String ALIGNMENT_DESCRIPTION = "This is a test.";

    protected <T extends BaseEntity> T createRecord(boolean isExpectedException, R2dbcRepository<T, UUID> repo, T obj) {

    	log.info("Insert into database (" + obj.getClass().getName() + ")");
    	T save = null;

//    	try {
//	    	save = repo.save(obj);
//    	}
//    	catch (Exception e) {
//    		if (!isExpectedException) {
//    			e.printStackTrace();
//    		}
//    	}

    	return save;
    }

    protected <T extends BaseEntity> T readRecord(boolean isValid, R2dbcRepository<T, UUID> repo, T obj, Consumer<T> f) {
    	return readRecord(isValid, repo, obj.getId(), f);
    }

    protected <T extends BaseEntity> T readRecord(boolean isValid, R2dbcRepository<T, UUID> repo, UUID id, Consumer<T> f) {
    	
    	Optional<T> found = Optional.empty();

//    	log.info("Retrieve from database (" + id + ")");
//    	found = repo.findById(id);	// NOTE: Do NOT use getById() or getReferenceById() since those retrieve lazily and can easily cause problems.
//
//        assertNotNull(found, "Cannot be null");
//    	if (isValid) {
//	        assertEquals(true, found.isPresent(), "Cannot be null");
//	        assertEquals(id, found.get().getId());
//	    	f.accept(found.get());
//    	}
//    	else {
//    		assertEquals(true, found.isEmpty());
//    	}

        return found.isPresent()?found.get():null;
    }

}
