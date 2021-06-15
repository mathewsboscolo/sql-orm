package dev.mathews.shared.exception;

import org.jetbrains.annotations.NotNull;

public class SubscriptionNotFoundException extends Exception {

    public SubscriptionNotFoundException(@NotNull Class<?> clazz) {
        super("Subscription not found (" + clazz + ")");
    }
}
