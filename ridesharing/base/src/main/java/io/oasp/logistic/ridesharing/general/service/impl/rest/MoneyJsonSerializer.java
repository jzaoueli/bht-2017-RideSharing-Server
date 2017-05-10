package io.oasp.logistic.ridesharing.general.service.impl.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.oasp.logistic.ridesharing.general.common.api.datatype.Money;

import java.io.IOException;

/**
 * The {@link JsonSerializer} for {@link Money}.
 *
 */
public final class MoneyJsonSerializer extends JsonSerializer<Money> {

  @Override
  public void serialize(Money value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

    if (value != null) {
      jgen.writeString(value.getValue().toString());
    }
  }
}
