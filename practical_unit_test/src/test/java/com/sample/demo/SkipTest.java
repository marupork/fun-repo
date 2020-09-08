package com.sample.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SkipTest {

    @Test
    void shouldBeRun() {
        System.out.println("running!");
    }

    @Disabled
    @Test
    void shouldBeSkipped() {
        System.out.println("Skip me please");
    }
}
