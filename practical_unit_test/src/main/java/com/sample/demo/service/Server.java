package com.sample.demo.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Server {

    private final ExecutorService executorService;
    private final TaskService taskService;

    public Server(ExecutorService executorService, TaskService taskService) {
        this.executorService = executorService;
        this.taskService = taskService;
    }

    public void serve(Collection<Task> tasks) {
        tasks.forEach(task -> executorService.submit(new TaskHandler(taskService, task)));
    }
}

interface TaskService {
    void handle(Task task);
}

class Task {

}

class TaskHandler implements Runnable {
    private final TaskService taskService;
    private final Task task;

    TaskHandler(TaskService taskService, Task task) {
        this.taskService = taskService;
        this.task = task;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskService.handle(task);
    }
}