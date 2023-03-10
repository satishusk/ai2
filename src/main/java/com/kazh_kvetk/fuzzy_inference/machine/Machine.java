package com.kazh_kvetk.fuzzy_inference.machine;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import com.kazh_kvetk.fuzzy_inference.machine.units.Rule;
import java.util.Queue;

public interface Machine {
  void accumulate(Rule rule, Queue<Long> inputs);
  Long mostConsistentRuleResult();
  ConclusionFunction mostConsistentFunction();
}
