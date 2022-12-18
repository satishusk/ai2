package com.kazh_kvetk.fuzzy_inference.machine;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
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
    if (ruleCompliance != 0) {
      compliances.put(ruleCompliance, rule);
    }
    accumulator = Math.max(accumulator, ruleCompliance);
  }

  @Override
  public Integer mostConsistentRuleResult() {
    Rule rule = compliances.get(accumulator);
    if (rule == null) {
      return 0;
    }
    return rule.getConclusionFunction().apply(accumulator);
  }

  @Override
  public ConclusionFunction mostConsistentFunction() {
    Rule rule = compliances.get(accumulator);
    if (rule == null) {
      return new ConclusionFunction() {
        @Override
        protected Integer accumulate(Double membershipPower) {
          return 0;
        }

        @Override
        public String functionName() {
          return "ErrorDemand";
        }
      };
    }
    return rule.getConclusionFunction();
  }
}
