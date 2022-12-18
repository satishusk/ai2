package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import org.springframework.stereotype.Component;

@Component
public class HighDemand extends ConclusionFunction {

  @Override
  protected Long accumulate(Double membershipPower) {
    if (membershipPower <= 0.4) {
      return 0L;
    }
    return (long) (100 * (membershipPower/0.6 - 2/3.0));
  }

  @Override
  public String functionName() {
    return "HighDemand";
  }
}
