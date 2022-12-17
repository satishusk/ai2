package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class MiddleDemand extends ConclusionFunction {

  @Override
  protected Integer accumulate(Double membershipPower) {
    if (membershipPower < 0.3 || membershipPower > 0.6) {
      return 3;
    }
    if (membershipPower <= 0.45) {
      return (int) (80/3 * membershipPower - 5);
    } else {
      return (int) (-80/3 * membershipPower + 19);
    }
  }
}
