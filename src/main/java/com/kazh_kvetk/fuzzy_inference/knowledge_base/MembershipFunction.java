package com.kazh_kvetk.fuzzy_inference.knowledge_base;

import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public abstract class MembershipFunction implements Function<Queue<Long>, Double> {

  @Override
  public Double apply(Queue<Long> inputs) {
    Double presumably = membershipPower(inputs);
    System.out.println(presumably + " - from " + this.getClass());
    return presumably < 0 ? 0 : presumably > 1 ? 1 : presumably;
  }

  protected abstract Double membershipPower(Queue<Long> inputs);
}
