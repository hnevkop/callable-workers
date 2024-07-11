package com.hnevkop.workers;

import org.springframework.stereotype.Service;

@Service
public class WorkerService {

  public void executeWorkers() {
    WorkersExecutor multiWorker = new WorkersExecutor(10);
    multiWorker.addTask(new Task("1"));
    multiWorker.addTask(new Task("5"));
    multiWorker.addTask(new Task("10"));

    try {
      multiWorker.executeAll(result -> System.out.println("Finished: " + result));
    } catch (Exception e) {
      e.printStackTrace();
    }
        }

}
