package com.mykytaaa.user.profile.service.e2e.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TestContextStorage {

    /**
     * Thread-local variable to store the test context.
     */
    private final ThreadLocal<TestContext> context = new ThreadLocal<>();

    /**
     * Retrieves the test context associated with the current thread.
     *
     * @return The test context associated with the current thread.
     */
    public TestContext getTestContext() {
        return context.get();
    }

    /**
     * Sets the test context for the current thread.
     *
     * @param context The test context to set for the current thread.
     */
    public void setContext(TestContext context) {
        TestContextStorage.context.set(context);
    }

    /**
     * Clears the test context associated with the current thread.
     */
    public void clearContext() {
        context.remove();
    }

}
