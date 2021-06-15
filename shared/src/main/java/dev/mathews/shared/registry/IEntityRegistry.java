package dev.mathews.shared.registry;

import dev.mathews.shared.entity.IEntitySubscription;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.BiConsumer;

public interface IEntityRegistry {

    void createRegistry(@NotNull IEntitySubscription subscription);

    void createRegistry(@NotNull Collection<IEntitySubscription> subscriptions);

    @NotNull Collection<Annotation> filter(BiConsumer<Class<?>, Annotation> biConsumer);
}