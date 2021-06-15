package dev.mathews.shared.entity;

import lombok.NonNull;

import java.lang.annotation.Annotation;

public interface IEntitySubscription {

    @NonNull Class<?> getEntitySubscription();

    @NonNull Annotation[] getAnnotations();
}