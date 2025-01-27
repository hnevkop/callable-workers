package com.hnevkop.workers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class WorkerService {

  public List<ID> executeWorkers() {

    long startTime = System.currentTimeMillis();
    WorkersExecutor workersExecutor = new WorkersExecutor(5);
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(50));
    workersExecutor.addTask(new Task(50));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(50));
    workersExecutor.addTask(new Task(50));
    workersExecutor.addTask(new Task(100));
    workersExecutor.addTask(new Task(100));
    // add tasks and threads to scale the application ... you get the point

    List<ID> results = Collections.synchronizedList(new ArrayList<>());
    try {
      workersExecutor.executeAll(
          result -> {
            System.out.println("Finished with results: " + result.response().length);
            results.addAll(Arrays.stream(result.response()).toList());
          });
    } catch (Exception e) {
      log.error("Error executing workers", e);
    }
    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
    log.info(
        "Application finished with no. of results: {} in seconds: {}", results.size(), elapsedTime);
    return results;
  }
}
