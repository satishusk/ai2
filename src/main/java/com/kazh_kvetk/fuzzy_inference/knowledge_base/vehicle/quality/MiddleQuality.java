package com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.Objects;
import java.util.Queue;
import org.springframework.stereotype.Component;

@Component
public class MiddleQuality extends MembershipFunction {

  @Override
  protected Double membershipPower(Queue<Long> inputs) {
    long x = Objects.requireNonNull(inputs.poll());
    if (x < 30) {
      return 0d;
    }
    if (x < 60) {
      return x / 30.0 - 1;
    }
    return 2.5 - x/40.0;
  }
}
