package dev.mathews.shared.validator;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractValidator {

    public Statement parse(@NotNull String query) throws JSQLParserException {
        return CCJSqlParserUtil.parse(query);
    }

    protected abstract boolean validate(@NotNull Statement statement);

    protected abstract boolean validate(@NotNull String query);
}
