package dev.mathews.shared.entity;

import dev.mathews.shared.exception.SubscriptionNotFoundException;
import lombok.NonNull;

import java.util.Collection;

public interface IEntitySubscriptionService {

    void subscribe(@NonNull IEntitySubscription subscription);

    void closeSubscription(@NonNull Class<?> clazz) throws SubscriptionNotFoundException;

    void closeSubscription(@NonNull IEntitySubscription subscription);

    IEntitySubscription findSubscription(@NonNull Class<?> clazz) throws SubscriptionNotFoundException;

    Collection<IEntitySubscription> getSubscriptions();
}