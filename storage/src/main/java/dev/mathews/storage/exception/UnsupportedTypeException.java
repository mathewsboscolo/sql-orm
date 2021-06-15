package dev.mathews.storage.exception;

import dev.mathews.storage.query.QueryType;
import org.jetbrains.annotations.NotNull;

public class UnsupportedTypeException extends Exception {

    public UnsupportedTypeException(@NotNull QueryType queryType) {
        super(queryType + " is not supported in this method");
    }
}
