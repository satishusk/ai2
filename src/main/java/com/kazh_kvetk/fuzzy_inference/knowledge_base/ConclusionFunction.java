package com.kazh_kvetk.fuzzy_inference.knowledge_base;

import java.util.function.Function;

public abstract class ConclusionFunction implements Function<Double, Long> {

  @Override
  public Long apply(Double membershipPower) {
    if (membershipPower < 0 || membershipPower > 1) {
      throw new IllegalArgumentException("Membership Power not must be less than 0 and above than"
        + " 1.");
    }
    Long presumably = accumulate(membershipPower);
    if (presumably < 0 || presumably > 100) {
      throw new IllegalArgumentException("Presumably accumulate not must be less than 0 or "
        + "above than 100, but have: " + presumably);
    }
    return presumably;

  }

  protected abstract Long accumulate(Double membershipPower);

  public abstract String functionName();
}
