package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class LowQuality extends MembershipFunction {
  @Override
  protected Double membershipPower(Queue<Integer> inputs) {
    int input = Objects.requireNonNull(inputs.poll());
    if (input < 0 || input > 4) {
      return 0d;
    }
    return -0.25 * input + 1;
  }
}
