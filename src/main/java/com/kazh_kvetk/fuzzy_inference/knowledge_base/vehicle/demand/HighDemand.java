package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class HighDemand extends ConclusionFunction {

  @Override
  protected Integer accumulate(Double membershipPower) {
    if (membershipPower <= 0.7) {
      return (int) (10/7 * membershipPower + 6);
    } else {
      return (int) (10 * membershipPower);
    }
  }
}
