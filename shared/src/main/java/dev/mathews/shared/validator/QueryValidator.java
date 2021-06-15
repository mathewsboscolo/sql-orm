package dev.mathews.shared.validator;

import dev.mathews.storage.query.QueryBuilder;
import dev.mathews.storage.query.QueryType;
import net.sf.jsqlparser.parser.feature.FeatureConfiguration;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.validation.Validation;
import net.sf.jsqlparser.util.validation.ValidationCapability;
import net.sf.jsqlparser.util.validation.ValidationContext;
import net.sf.jsqlparser.util.validation.ValidationException;
import net.sf.jsqlparser.util.validation.feature.DatabaseType;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class QueryValidator extends AbstractValidator {

    @Override
    public boolean validate(@NotNull Statement statement) {
        final ValidationContext context = Validation.createValidationContext(
          new FeatureConfiguration(), Collections.singletonList(DatabaseType.MYSQL)
        );
        final Map<ValidationCapability, Set<ValidationException>>
          validate = Validation.validate(statement, context);
        return validate.isEmpty();
    }

    @Override
    public boolean validate(@NotNull String query) {
        final Validation validation = new Validation(
          Collections.singletonList(DatabaseType.MYSQL),
          query
        );
        return !validation.getErrors().isEmpty();
    }

    public static void main(String[] args) {
        final String expressions = new QueryBuilder(QueryType.INSERT)
          .table("teste")
          .addColumn("coluna")
          .addExpression("valor")
          .build();
        System.out.println(expressions);
    }
}