# Callable Workers Application

Callable workers application is a demo of using Java Future and Callbacks to scale some work across multiple threads. 
e.g. to call an external services and get the response.

## Requirements
required java 17 or higher (build with java 21) 
gradle 7.2

## Description of the compoments:
- Worker - A worker is a class that implements Callable interface. It is responsible for doing some work and returning a result. For demo purposes set the sleep time to 500ms to simulate the work.
- WorkersExecutor - A class that is responsible for executing the workers. It takes a list of workers and executes them in parallel, collects the results. 
- WorkerService - A class that is responsible for calling the workers and getting the results. It uses WorkersExecutor to execute the workers. Demo purposes only. 

## Running the application

To run the application, execute the java class in the root directory of the project:
```shell
CallWorkersApplication.java
```

## Scaling the application
See Workers Executor class for the number of threads to be used in the application
, as well as the number of workers to be used. By default it is set to 10 workers and 5 threads.
Execution results is printed to the console.

***Basic description:*** 
1. WorkerExecutor is created with a number of threads
2. Task(s) is submitted to the executor
3. New Worker for the task is created and do the work. (This is generally non blocking since a new thread from the thread pool is used, or reused some existing thread from the pool),
   Future from the worker is saved to the list of futures.
4. WorkersExecutor method executeAll collects the results from the futures and returns the list of results.



## Building the application
use gradle to build the application:
```shell
gradle build
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### build status

[![Java CI with Gradle](https://github.com/hnevkop/callable-workers/actions/workflows/gradle.yml/badge.svg)](https://github.com/hnevkop/callable-workers/actions/workflows/gradle.yml)