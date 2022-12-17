package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class HighCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Integer> inputs) {
    int input = Objects.requireNonNull(inputs.poll());
    if (input < 5000) {
      return 0d;
    }
    if (input < 100_000) {
      return input / 95000.0 - 1/19.0;
    }
    return 1d;
  }
}
