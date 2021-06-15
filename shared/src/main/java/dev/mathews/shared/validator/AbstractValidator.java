package dev.mathews.shared.validator;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractValidator {

    /**
     * meu pau ta enorme
      * @param query
     * @return
     */
    public Statement parse(@NotNull String query) throws JSQLParserException {
        return CCJSqlParserUtil.parse(query);
    }

    /**
     * meu pau ta gigantesco
     * @param statement
     * @return
     */

    protected abstract boolean validate(@NotNull Statement statement);

    /**
     * meu pau
     * @return
     */
    protected abstract boolean validate(@NotNull String query);
}
