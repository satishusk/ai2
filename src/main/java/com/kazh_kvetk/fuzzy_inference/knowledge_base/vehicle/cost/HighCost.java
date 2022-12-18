package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import static java.lang.Math.*;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class HighCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long x = Objects.requireNonNull(inputs.poll());
    if (x <= 3_000_000) {
      return 0d;
    } else {
      return x / 7_000_000.0 - 3/7.0;
    }
  }
}
