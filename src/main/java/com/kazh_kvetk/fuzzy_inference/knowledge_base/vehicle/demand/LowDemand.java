package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class LowDemand extends ConclusionFunction {

  @Override
  protected Long accumulate(Double membershipPower) {
    if (membershipPower <= 0.2) {
      return 100L;
    }
    if (membershipPower <= 0.8) {
      return (long)  (100 * (-membershipPower / 0.6 + 4/3.0));
    }
    return 0L;
  }

  @Override
  public String functionName() {
    return "LowDemand";
  }
}
