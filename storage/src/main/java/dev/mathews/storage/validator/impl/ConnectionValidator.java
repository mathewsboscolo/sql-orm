package dev.mathews.storage.validator.impl;

import dev.mathews.storage.exception.ConnectionValidationException;
import dev.mathews.storage.validator.IConnectionValidator;
import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class ConnectionValidator implements IConnectionValidator {

    @Override
    public boolean validate(@NotNull DataSource dataSource) throws SQLException {
        final Connection connection = dataSource.getConnection();
        return connection != null && !connection.isClosed();
    }

    @Override
    public void testConnection(@NotNull DataSource dataSource) throws ConnectionValidationException {
        try (
          final Connection connection = dataSource.getConnection();
          final PreparedStatement statement = connection.prepareStatement("SELECT 1;")
        ) {
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new ConnectionValidationException();
        }
    }
}
