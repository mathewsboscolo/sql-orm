package dev.mathews.storage.validator;

import dev.mathews.storage.exception.ConnectionValidationException;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface IConnectionValidator {

    boolean validate(@NotNull DataSource dataSource) throws ConnectionValidationException, SQLException;

    void testConnection(@NotNull DataSource dataSource) throws ConnectionValidationException;
}