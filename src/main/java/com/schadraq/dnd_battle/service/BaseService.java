package com.schadraq.dnd_battle.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

/**
 * NOTE: Business logic is stored in the service layer. It includes validation
 *       logic in particular. The model state is used to communicate between
 *       the controller and service layers.
 *       
 *       There are advantages and disadvantages to treating validation as
 *       business logic, and Spring’s validation (and data binding)
 *       architecture does not preclude either. Validation, in particular,
 *       should not be bound to the web tier, should be simple to localize,
 *       and should allow for the use of any validator available.
 *       
 *       Also, client input data does not always pass through the REST
 *       controller process, and if we don’t validate in the Service layer as
 *       well, unacceptable data can pass through, causing several issues. In
 *       this case, we’ll use the standard Java JSR-303 validation scheme.
 */
@Service
public abstract class BaseService {

    @Autowired
    private Validator validator;

	protected <T> Set<ConstraintViolation<T>> getConstraintViolations(T obj) {
        
        Set<ConstraintViolation<T>> violations = validator.validate(obj);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        return violations;
	}
}
