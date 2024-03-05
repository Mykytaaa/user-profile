package com.mykytaaa.user.profile.service.e2e.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TestContextStorage {

    private final ThreadLocal<TestContext> context = new ThreadLocal<>();

    public TestContext getTestContext() {
        return context.get();
    }

    public void setContext(TestContext context) {
        TestContextStorage.context.set(context);
    }

    public void clearContext() {
        context.remove();
    }
}
