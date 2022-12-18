package com.kazh_kvetk.fuzzy_inference.knowledge_base;

import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public abstract class MembershipFunction implements Function<Queue<Long>, Double> {

  @Override
  public Double apply(Queue<Long> inputs) {
    Double presumably = membershipPower(inputs);
    if (presumably < 0 || presumably > 1) {
      throw new IllegalArgumentException("Presumably accumulate not must be less than 0 or "
        + "above than 1, but have: " + presumably);
    }
    return presumably;
  }

  protected abstract Double membershipPower(Queue<Long> inputs);
}
