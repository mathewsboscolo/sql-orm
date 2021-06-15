package dev.mathews.shared.entity.impl;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.entity.IEntitySubscriptionService;
import dev.mathews.shared.exception.SubscriptionNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class EntitySubscriptionService implements IEntitySubscriptionService {

    private final HashSet<IEntitySubscription> subscriptions = new LinkedHashSet<>();

    @Override
    public void subscribe(@NotNull IEntitySubscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public void closeSubscription(@NotNull Class<?> clazz) throws SubscriptionNotFoundException {
        subscriptions.remove(findSubscription(clazz));
    }

    @Override
    public void closeSubscription(@NotNull IEntitySubscription subscription) {
        subscriptions.remove(subscription);
    }

    @Override
    public IEntitySubscription findSubscription(@NotNull Class<?> clazz) throws SubscriptionNotFoundException {
        return subscriptions.stream()
          .filter(subscription -> subscription.getEntitySubscription().equals(clazz))
          .findFirst()
          .orElseThrow(() -> new SubscriptionNotFoundException(clazz));
    }

    @Override
    public Collection<IEntitySubscription> getSubscriptions() {
        return subscriptions;
    }
}