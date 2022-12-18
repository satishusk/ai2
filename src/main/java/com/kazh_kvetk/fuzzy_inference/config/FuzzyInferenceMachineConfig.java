package com.kazh_kvetk.fuzzy_inference.config;

import com.kazh_kvetk.fuzzy_inference.machine.Machine;
import com.kazh_kvetk.fuzzy_inference.machine.MachineDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuzzyInferenceMachineConfig {
  @Bean
  public Machine machine() {
    return new MachineDefault();
  }
}
