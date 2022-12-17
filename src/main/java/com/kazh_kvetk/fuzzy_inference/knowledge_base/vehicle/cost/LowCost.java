package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class LowCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Integer> inputs) {
    int input = Objects.requireNonNull(inputs.poll());
    if (input < 20 || input > 400) {
      return 0d;
    }
    return -input / 380.0 + 20/19.0;
  }
}
