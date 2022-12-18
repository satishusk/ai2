package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class LowCost extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long x = Objects.requireNonNull(inputs.poll());
    if (x >= 1_000_000 && x < 8_000_000) {
      return -x / 7_000_000.0 + 8/7.0;
    } else {
      return 0d;
    }
  }
}
