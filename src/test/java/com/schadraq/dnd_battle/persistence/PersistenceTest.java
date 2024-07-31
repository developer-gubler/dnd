package com.schadraq.dnd_battle.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersistenceTest {

    protected <T extends BaseEntity> T createRecord(boolean isExpectedException, JpaRepository<T, Long> repo, T obj) {

    	log.info("Insert into database (" + obj.getClass().getName() + ")");
    	T save = null;

    	try {
	    	save = repo.save(obj);
    	}
    	catch (Exception e) {
    		if (!isExpectedException) {
    			e.printStackTrace();
    		}
    	}

    	return save;
    }

    protected <T extends BaseEntity> T readRecord(JpaRepository<T, Long> repo, T obj, Consumer<T> f) {
    	return readRecord(repo, obj.getId(), f);
    }

    protected <T extends BaseEntity> T readRecord(JpaRepository<T, Long> repo, Long id, Consumer<T> f) {
    	
    	Optional<T> found = Optional.empty();

    	log.info("Retrieve from database (" + id + ")");
    	found = repo.findById(id);	// NOTE: Do NOT use getById() or getReferenceById() since those retrieve lazily and can easily cause problems.

        assertNotNull(found, "Cannot be null");
        assertEquals(id, found.get().getId());
    	f.accept(found.get());

        return found.get();
    }

}
