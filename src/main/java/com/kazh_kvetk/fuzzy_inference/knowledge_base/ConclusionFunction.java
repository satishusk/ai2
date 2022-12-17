package com.kazh_kvetk.fuzzy_inference.knowledge_base;

import java.util.function.Function;

public abstract class ConclusionFunction implements Function<Double, Integer> {

  @Override
  public Integer apply(Double membershipPower) {
    if (membershipPower < 0 || membershipPower > 1) {
      throw new IllegalArgumentException("Membership Power must be less than 0 and above than 1.");
    }
    return accumulate(membershipPower);
  }

  protected abstract Integer accumulate(Double membershipPower);
}
