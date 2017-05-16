package io.oasp.logistic.ridesharing.general.dataaccess.base;

import io.oasp.logistic.ridesharing.general.common.api.datatype.Money;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

/**
 * This is the {@link AttributeConverter} to allow that JPA vendors can persist instances of {@link Money} if used in
 * {@link io.oasp.logistic.ridesharing.general.common.api.ApplicationEntity entities}.
 *
 */
@Converter(autoApply = true)
public class MoneyAttributeConverter implements AttributeConverter<Money, BigDecimal> {

  /**
   * The constructor.
   */
  public MoneyAttributeConverter() {

    super();
  }

  @Override
  public BigDecimal convertToDatabaseColumn(Money attribute) {

    if (attribute == null) {
      return null;
    }
    return attribute.getValue();
  }

  @Override
  public Money convertToEntityAttribute(BigDecimal dbData) {

    if (dbData == null) {
      return null;
    }
    return new Money(dbData);
  }

}
