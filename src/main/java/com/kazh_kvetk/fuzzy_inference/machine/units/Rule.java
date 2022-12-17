package com.kazh_kvetk.fuzzy_inference.machine.units;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.ConclusionFunction;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.MembershipFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Rule extends MembershipFunction {
  private final List<MembershipFunction> functionsOnLevel = new ArrayList<>();
  private final List<Logic> operatorsOnLevel = new ArrayList<>();

  private ConclusionFunction conclusionFunction;

  private static int depthLevel = 1;

  private String depthLevelInfo() {
    return "-------   ".repeat(Math.max(0, depthLevel));
  }

  @Override
  protected Double membershipPower(Queue<Integer> inputs) {
    System.out.println(depthLevelInfo());
    depthLevel++;
    Double accumulator = functionsOnLevel.get(0).apply(inputs);
    for (int i = 0; i < operatorsOnLevel.size(); i++) {
      accumulator = switch (operatorsOnLevel.get(i)) {
        case AND -> Math.min(accumulator,
          functionsOnLevel.get(i + 1).apply(inputs));

        case OR -> Math.max(accumulator,
          functionsOnLevel.get(i + 1).apply(inputs));
      };
    }
    depthLevel--;
    return accumulator;
  }

  public enum Logic {
    AND, OR;
  }

  public Builder start(MembershipFunction startFunction) {
    functionsOnLevel.add(startFunction);
    return new Builder();
  }

  public class Builder {
    public Builder or(MembershipFunction function) {
      functionsOnLevel.add(function);
      operatorsOnLevel.add(Logic.OR);
      return this;
    }

    public Builder and(MembershipFunction function) {
      functionsOnLevel.add(function);
      operatorsOnLevel.add(Logic.AND);
      return this;
    }

    public Rule end() {
      return Rule.this;
    }

    public Rule conclusion(ConclusionFunction conclusionFunction) {
      Rule.this.conclusionFunction = conclusionFunction;
      return Rule.this;
    }
  }

  public ConclusionFunction getConclusionFunction() {
    return conclusionFunction;
  }
}
