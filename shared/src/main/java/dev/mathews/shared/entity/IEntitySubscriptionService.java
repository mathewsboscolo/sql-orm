package dev.mathews.shared.entity;

import dev.mathews.shared.exception.SubscriptionNotFoundException;
import lombok.NonNull;

import java.util.Collection;

public interface IEntitySubscriptionService {

    void subscribe(@NonNull IEntitySubscription subscription);

    /**
     *
     * @param clazz
     */

    void closeSubscription(@NonNull Class<?> clazz) throws SubscriptionNotFoundException;

    /**
     * meu pau
     * @param subscription
     */

    void closeSubscription(@NonNull IEntitySubscription subscription);

    /**
     * filha da puta
     * @param clazz
     * @return
     */

    IEntitySubscription findSubscription(@NonNull Class<?> clazz) throws SubscriptionNotFoundException;

    /**
     * meu pau
     * @return
     */

    Collection<IEntitySubscription> getSubscriptions();
}