package dev.mathews.shared.entity.impl;

import dev.mathews.shared.entity.IEntitySubscription;
import lombok.Data;
import lombok.NonNull;

import java.lang.annotation.Annotation;

@Data
public class EntitySubscription implements IEntitySubscription {

    private final Class<?> entityClass;
    private final Annotation[] annotations;

    @Override
    public @NonNull Class<?> getEntitySubscription() {
        return entityClass;
    }

    @Override
    public @NonNull Annotation[] getAnnotations() {
        return annotations;
    }
}