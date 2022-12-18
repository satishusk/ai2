package com.kazh_kvetk.fuzzy_inference;

import com.kazh_kvetk.fuzzy_inference.machine.Machine;
import com.kazh_kvetk.fuzzy_inference.machine.units.Rule;
import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    Rule ruleHighDemand = context.getBean("ruleHighDemand", Rule.class);
    Rule ruleMiddleDemand = context.getBean("ruleMiddleDemand", Rule.class);
    Rule ruleLowDemand = context.getBean("ruleLowDemand", Rule.class);
    Machine machine = context.getBean("machine", Machine.class);

    try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("\n");
      System.out.print("Cost: ");
      Integer cost = Integer.parseInt(r.readLine()) / 1000;

      System.out.print("Quality: ");
      Integer quality = Integer.parseInt(r.readLine()) / 10;
      System.out.println("\n");

      Queue<Integer> preparedInputs = new ArrayDeque<>(
        List.of(cost, quality, cost, quality, cost, quality)
      );

      machine.accumulate(ruleHighDemand, new ArrayDeque<>(preparedInputs));
      machine.accumulate(ruleMiddleDemand, new ArrayDeque<>(preparedInputs));
      machine.accumulate(ruleLowDemand, new ArrayDeque<>(preparedInputs));

      System.out.println("\n");
      System.out.println("Input: Cost=" + cost * 1000 + ", Quality=" + quality * 10 + "%");
      System.out.println("Output: Demand=" + machine.mostConsistentRuleResult() * 10 + "%, " + machine.mostConsistentFunction().functionName());
      System.out.println("\n");
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    context.close();
  }
}
