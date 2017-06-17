package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api;

import java.util.List;

import javax.validation.Valid;

import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.common.api.TransportPoint;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.to.TransportPointEto;

public interface TransportPointmanagement {

  List<TransportPointEto> findAllTransportPoints();

  TransportPointEto findTransportPoint(Long id);

  TransportPointEto saveTransportPoint(@Valid TransportPoint transportPoint);

  void deleteTransportPoint(Long transportPointId);

}
