package com.kazh_kvetk.fuzzy_inference.config;

import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost.HighCost;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost.LowCost;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.cost.MiddleCost;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand.HighDemand;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand.LowDemand;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.demand.MiddleDemand;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality.HighQuality;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality.LowQuality;
import com.kazh_kvetk.fuzzy_inference.knowledge_base.vehicle.quality.MiddleQuality;
import com.kazh_kvetk.fuzzy_inference.machine.units.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class RulesConfig {
  @Bean
  public Rule ruleHighDemand(LowCost lowCost, MiddleCost middleCost,
    HighQuality highQuality, MiddleQuality middleQuality) {
    return new Rule()
      .start(new Rule().start(lowCost).and(highQuality).end())
      .or(new Rule().start(middleCost).and(highQuality).end())
      .or(new Rule().start(lowCost).and(middleQuality).end())
      .conclusion(new HighDemand());
  }

  @Bean
  public Rule ruleMiddleDemand(LowCost lowCost, MiddleCost middleCost, HighCost highCost,
    LowQuality lowQuality, MiddleQuality middleQuality, HighQuality highQuality) {
    return new Rule()
      .start(new Rule().start(middleCost).and(middleQuality).end())
      .or(new Rule().start(lowCost).and(lowQuality).end())
      .or(new Rule().start(highCost).and(highQuality).end())
      .conclusion(new MiddleDemand());
  }

  @Bean
  public Rule ruleLowDemand(HighCost highCost, MiddleCost middleCost,
    MiddleQuality middleQuality, LowQuality lowQuality) {
    return new Rule()
      .start(new Rule().start(highCost).and(middleQuality).end())
      .or(new Rule().start(highCost).and(middleQuality).end())
      .or(new Rule().start(middleCost).and(lowQuality).end())
      .conclusion(new LowDemand());
  }
}
