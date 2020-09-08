package com.sample.demo.service;

import java.util.Calendar;

public class HelloService {

    private final TimeProvider timeProvider;

    public HelloService(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String sayHello() {
        Calendar current = timeProvider.getTime();

        if (current.get(Calendar.HOUR_OF_DAY) < 12) {
            return "Good Morning!";
        } else {
            return "Good Afternoon!";
        }
    }
}

interface TimeProvider {
    Calendar getTime();
}
