package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class LowQuality extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long x = Objects.requireNonNull(inputs.poll());
    if (x <= 20) {
      return 1d;
    }
    if (x < 60) {
      return -0.025 * x + 1.5;
    }
    return 0d;
  }
}
