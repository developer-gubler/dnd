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
import reactor.core.publisher.Mono;

@Slf4j
public class PersistenceTest {

	protected static final String ALIGNMENT_ABBR = "T";

	protected static final String ALIGNMENT_NAME = "test";

	protected static final String ALIGNMENT_DESCRIPTION = "This is a test.";

    protected <T extends BaseEntity> Mono<T> createRecord(boolean isExpectedException, R2dbcRepository<T, UUID> repo, T obj) {

    	log.info("Insert into database (" + obj.getClass().getName() + ")");
    	Mono<T> save = Mono.empty();

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

    protected <T extends BaseEntity> Mono<T> readRecord(boolean isValid, R2dbcRepository<T, UUID> repo, T obj, Consumer<T> f) {
    	return readRecord(isValid, repo, obj.getId(), f);
    }

    protected <T extends BaseEntity> Mono<T> readRecord(boolean isValid, R2dbcRepository<T, UUID> repo, UUID id, Consumer<T> f) {
    	
    	log.info("Retrieve from database (" + id + ")");
    	return repo.findById(id)
    				.flatMap(i -> {
    			        assertNotNull(i, "Cannot be null");
    			    	if (isValid) {
    				        assertEquals(true, i!=null, "Cannot be null");
    				        assertEquals(id, i.getId());
    				    	f.accept(i);
    			    	}
    			    	else {
    			    		assertEquals(true, i==null);
    			    	}
    			    	return Mono.just(i);
    				});	// NOTE: Do NOT use getById() or getReferenceById() since those retrieve lazily and can easily cause problems.
    }

}
