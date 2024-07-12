package com.hnevkop.workers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class WorkersExecutor {

  private final ExecutorService executorService;
  private final List<Future<Result>> futures = new ArrayList<>();

  public WorkersExecutor(int numberOfThreads) {
    executorService = Executors.newFixedThreadPool(numberOfThreads);
  }

  /**
   * Add a task to the executor
   * @param task
   */
  public void addTask(Task task) {
    Future<Result> future = executorService.submit(new Worker(task));
    futures.add(future);
  }

  /**
   * Execute all the tasks and call the callback for each result
   * @param callback
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public void executeAll(Consumer<Result> callback)
      throws ExecutionException, InterruptedException {
    for (Future<Result> future : futures) {
      callback.accept(future.get());
    }
    executorService.shutdown();
  }
}
