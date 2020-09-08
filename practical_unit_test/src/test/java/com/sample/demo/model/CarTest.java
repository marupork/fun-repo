package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarTest {

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        Car car = mock(Car.class);

        assertThat(car.needsFuel()).isFalse();
        assertThat(car.getEngineTemperature()).isEqualTo(0.0);
        assertThat(car.getName()).isNull();
    }
}
