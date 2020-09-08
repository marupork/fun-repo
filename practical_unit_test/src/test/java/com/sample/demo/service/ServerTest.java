package com.sample.demo.service;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServerTest {

    @Test
    void shouldSaveTasksAsync() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TaskService taskService = mock(TaskService.class);

        Task task = mock(Task.class);
        Collection<Task> taskList = Collections.singletonList(task);

        Server server =  new Server(executorService, taskService);

        server.serve(taskList);

        /*Thread.sleep(1005);
        verify(taskService).handle(task);*/

        /*boolean handleMethodInvoked = false;
        while(!handleMethodInvoked) {
            try {
                verify(taskService).handle(task);
                handleMethodInvoked = true;
            }
            catch (AssertionError e) {
                // no need to do anything
            }
            Thread.sleep(100);
        }
        assertThat(handleMethodInvoked).isTrue();*/

        Awaitility
            .await()
            // .atMost(1, SECONDS)
            .with().pollInterval(100, MILLISECONDS)
            .until(() -> {
                try {
                    verify(taskService).handle(task);
                    return true;
                } catch (AssertionError e) {
                    return false;
                }
            });
    }

    @Test
    void shouldSaveTasksSync()  {
        TaskService taskService = mock(TaskService.class);
        ExecutorService executorService = new SynchronousExecutorService();

        Task task = mock(Task.class);
        Collection<Task> taskList = Collections.singletonList(task);

        Server server = new Server(executorService, taskService);

        server.serve(taskList);

        verify(taskService).handle(task);
    }
}

class SynchronousExecutorService extends AbstractExecutorService {
    private boolean shutdown;

    public void shutdown() {
        this.shutdown = true;
    }

    public List<Runnable> shutdownNow() {
        shutdown = true;
        return Collections.emptyList();
    }

    public boolean isShutdown() {
        shutdown = true;
        return shutdown;
    }

    public boolean isTerminated() {
        return shutdown;
    }

    public boolean awaitTermination(final long timeout, final TimeUnit unit) {
        return true;
    }

    public void execute(final Runnable command) {
        command.run();
    }
}