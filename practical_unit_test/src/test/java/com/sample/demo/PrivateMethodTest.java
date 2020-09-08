package com.sample.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class PrivateMethodTest {

    @Test
    void testingPrivateMethodWithReflection() throws Exception {
        PrivateMethod sutService = new PrivateMethod();

        Method privateMethod = sutService.getClass().getDeclaredMethod("privateMethod", Long.class, String.class);
        privateMethod.setAccessible(true);

        Boolean result = (Boolean) privateMethod.invoke(sutService, 1L, "a");
        assertThat(result).isTrue();
    }

    @Test
    void testingPrivateMethodWithReflectionUtils() throws Exception {
        PrivateMethod sutService = new PrivateMethod();

        Method privateMethod = sutService.getClass().getDeclaredMethod("privateMethod", Long.class, String.class);
        ReflectionUtils.makeAccessible(privateMethod);

        Boolean result =  (Boolean) privateMethod.invoke(sutService, 1L, "a");
        assertThat(result).isTrue();
    }
}