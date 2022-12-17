package com.kazh_kvetk.fuzzy_inference.machine;

import com.kazh_kvetk.fuzzy_inference.machine.units.Rule;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MachineDefault implements Machine {
  private final Map<Double, Rule> compliances = new HashMap<>();
  private Double accumulator = 0d;

  @Override
  public void accumulate(Rule rule, Queue<Integer> inputs) {
    Double ruleCompliance = rule.apply(inputs);
    compliances.put(ruleCompliance, rule);
    accumulator = Math.max(accumulator, ruleCompliance);
  }

  @Override
  public Integer mostConsistentRuleResult() {
    return compliances.get(accumulator).getConclusionFunction().apply(accumulator);
  }
}
