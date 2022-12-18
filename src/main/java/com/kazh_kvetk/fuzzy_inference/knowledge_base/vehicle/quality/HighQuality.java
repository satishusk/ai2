package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class HighQuality extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long input = Objects.requireNonNull(inputs.poll());
    if (input < 6) {
      return 0d;
    }
    if (input < 10) {
      return 0.25 * input - 1.5;
    }
    return 1d;
  }
}
