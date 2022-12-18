package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class LowDemand extends ConclusionFunction {

  @Override
  protected Long accumulate(Double membershipPower) {
    if (membershipPower <= 0.6) {
      return (long) (-5/3 * membershipPower + 4);
    } else {
      return (long) (-7.5 * membershipPower + 7.5);
    }
  }

  @Override
  public String functionName() {
    return "LowDemand";
  }
}
