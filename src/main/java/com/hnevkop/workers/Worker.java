package com.hnevkop.workers;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
class Worker implements Callable<Result> {
    private final Task task;

    public Worker(Task task) {
        this.task = task;
    }

    /**
     * Do the work for the task. E.g. call external service
     * @return
     * @throws Exception
     */
    @Override
    public Result call() throws Exception {
        // e.g. call external service with the values provided
        Thread currentThread = Thread.currentThread();
        log.info("Doing some hard work for task: {} on thread: {}", task, currentThread.getName());
        Thread.sleep(500);

        // DUMMY result of the work
        int numberOfIds = task.taskParameter();
        ID[] ids = new ID[numberOfIds];
        for (int i = 0; i < numberOfIds; i++) {
            ids[i] = new ID();
        }
        return new Result(ids);
    }
}

