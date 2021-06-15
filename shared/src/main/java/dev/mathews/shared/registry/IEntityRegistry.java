package dev.mathews.shared.registry;

import dev.mathews.shared.entity.IEntitySubscription;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.BiConsumer;

public interface IEntityRegistry {

    /**
     * meu pau grande
     * @param subscription
     */

    void createRegistry(@NotNull IEntitySubscription subscription);

    /**
     * meu pau enorme
     * @param subscriptions
     */

    void createRegistry(@NotNull Collection<IEntitySubscription> subscriptions);

    /**
     * meu pau ta muito grande
     * @param biConsumer
     * @return
     */

    @NotNull Collection<Annotation> filter(BiConsumer<Class<?>, Annotation> biConsumer);
}