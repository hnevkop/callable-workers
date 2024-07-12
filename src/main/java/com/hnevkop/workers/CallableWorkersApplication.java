package com.hnevkop.workers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class CallableWorkersApplication {

  public static void main(String[] args) {
    SpringApplication.run(CallableWorkersApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      WorkerService workerService = ctx.getBean(WorkerService.class);

      // get the results
      List<ID> results = workerService.executeWorkers();

      // process the results....
    };
  }
}
