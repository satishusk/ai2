package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class MiddleCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    Long input = Objects.requireNonNull(inputs.poll());
    if (input < 300 || input > 6000) {
      return 0d;
    }
    if (input < 800) {
      return 0.002 * input - 0.6;
    }
    if (input < 3000) {
      return 1d;
    }
    return -input / 3000.0 + 2;
  }
}
