package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import static java.lang.Math.*;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class MiddleCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long x = Objects.requireNonNull(inputs.poll());
    if (x < 1_000_000) {
      return 0d;
    }
    if (x <= 6_000_000) {
      return x / 5_000_000.0 - 0.2;
    }
    return 2.5 - x / 4_000_000.0;
  }
}
