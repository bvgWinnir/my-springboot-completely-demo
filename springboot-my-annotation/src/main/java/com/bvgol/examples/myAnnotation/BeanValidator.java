package com.bvgol.examples.myAnnotation;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * 参数校验工具
 *
 * @author Hollis
 */

public class BeanValidator {

    private static Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true)

            .buildValidatorFactory().getValidator();

    /**
     * @param object object
     * @param groups groups
     */

    public static void validateObject(Object object, Class<?>... groups) throws ValidationException {

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);

        if (constraintViolations.stream().findFirst().isPresent()) {

            throw new ValidationException(constraintViolations.stream().findFirst().get().getMessage());

        }

    }

}
