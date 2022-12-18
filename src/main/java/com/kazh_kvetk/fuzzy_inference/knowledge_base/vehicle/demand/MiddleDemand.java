package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class MiddleDemand extends ConclusionFunction {

  @Override
  protected Long accumulate(Double membershipPower) {
    if (membershipPower <= 0.2) {
      return 0L;
    }
    if (membershipPower <= 0.6) {
      return (long) (100 * (membershipPower / 0.4 - 1/2.0));
    }
    return (long) (100 * (-membershipPower / 0.4 + 2.5));
  }

  @Override
  public String functionName() {
    return "MiddleDemand";
  }
}
