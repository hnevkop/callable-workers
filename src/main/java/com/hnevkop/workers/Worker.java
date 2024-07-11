package com.hnevkop.workers;

import java.util.concurrent.Callable;


class Worker implements Callable<Result> {
    private final Task task;

    public Worker(Task task) {
        this.task = task;
    }

    @Override
    public Result call() throws Exception {
        // e.g. call external service with the values provided
        System.out.println("Doing some hard work for task: " + task);
        Thread.sleep(100);
        // Set the result of the work
        return new Result(task + " completed");
    }
}

