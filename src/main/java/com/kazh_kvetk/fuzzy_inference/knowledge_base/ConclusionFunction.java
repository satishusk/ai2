package com.kazh_kvetk.fuzzy_inference.knowledge_base;

import java.util.function.Function;

public abstract class ConclusionFunction implements Function<Double, Long> {

  @Override
  public Long apply(Double membershipPower) {
    if (membershipPower < 0 || membershipPower > 1) {
      throw new IllegalArgumentException("Membership Power must be less than 0 and above than 1.");
    }
    return accumulate(membershipPower);
  }

  protected abstract Long accumulate(Double membershipPower);

  public abstract String functionName();
}
