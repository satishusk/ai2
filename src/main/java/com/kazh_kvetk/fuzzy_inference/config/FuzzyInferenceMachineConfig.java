package com.kazh_kvetk.fuzzy_inference.config;

import com.kazh_kvetk.fuzzy_inference.machine.Machine;
import com.kazh_kvetk.fuzzy_inference.machine.MachineDefault;
import com.kazh_kvetk.fuzzy_inference.machine.units.Rule;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuzzyInferenceMachineConfig {
  private static final Integer COST = 400;
  private static final Integer QUALITY = 6;
  private static final Queue<Integer> preparedInputs
    = new ArrayDeque<>(List.of(COST, QUALITY, COST, QUALITY, COST, QUALITY));

  @Bean
  public Machine machine(Rule ruleHighDemand, Rule ruleMiddleDemand, Rule ruleLowDemand) {
    Machine machine = new MachineDefault();
    machine.accumulate(ruleHighDemand, new ArrayDeque<>(preparedInputs));
    machine.accumulate(ruleMiddleDemand, new ArrayDeque<>(preparedInputs));
    machine.accumulate(ruleLowDemand, new ArrayDeque<>(preparedInputs));

    System.out.println("\n");
    System.out.println("Input: Cost=" + COST + ", Quality=" + QUALITY);
    System.out.println("Output: Demand=" + machine.mostConsistentRuleResult());
    System.out.println("\n");
    return machine;
  }
}
