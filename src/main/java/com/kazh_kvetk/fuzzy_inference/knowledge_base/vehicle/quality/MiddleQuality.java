package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class MiddleQuality extends MembershipFunction {

  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long input = Objects.requireNonNull(inputs.poll());
    if (input < 3 || input > 7) {
      return 0d;
    }
    if (input < 5) {
      return 0.5 * input - 1.5;
    }
    return -0.5 * input + 3.5;
  }
}
