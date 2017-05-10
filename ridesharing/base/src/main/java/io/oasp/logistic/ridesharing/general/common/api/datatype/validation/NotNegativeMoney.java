package io.oasp.logistic.ridesharing.general.common.api.datatype.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Constraint for validator {@link NotNegativeMoneyValidator}.
 *
 */
@Documented
@Target({ METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNegativeMoneyValidator.class)
public @interface NotNegativeMoney {

  /**
   * The default message displayed when the validation fails.
   */
  String message() default "The price must not be negative";

  /**
   * The default groups of this constraint.
   */
  Class<?>[] groups() default {};

  /**
   * The payload element of this constraint.
   */
  Class<? extends Payload>[] payload() default {};
}
