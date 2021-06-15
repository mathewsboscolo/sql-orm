package dev.mathews.storage.query;

import dev.mathews.storage.factory.ReplaceColumnValues;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class QueryBuilder {

    private QueryType queryType;
    private Statement statement;

    private String query;
    private Table table;

    private final List<Column> columns = new LinkedList<>();
    private final List<Expression> expressions = new LinkedList<>();

    private final List<ColumnDefinition> columnDefinitions = new LinkedList<>();

    public QueryBuilder(QueryType queryType) {
        this.queryType = queryType;
    }

    public QueryBuilder(Statement statement) {
        this.statement = statement;
    }

    public QueryBuilder table(String tableName) {
        this.table = new Table(tableName);
        return this;
    }

    public QueryBuilder addColumn(@NotNull String... columns) {
        for (String columnName : columns) {
            final Column column =  new Column(columnName);
            this.columns.add(column);
        }
        return this;
    }

    public QueryBuilder addExpression(@NotNull String... expressions) {
        for (String expressionName : expressions) {
            final Expression expression = new StringValue(expressionName);
            this.expressions.add(expression);
        }
        return this;
    }

    public List<Column> getColumns()  {
        return columns;
    }

    public String buildAsBuffer(String character) {
        columns.forEach(column -> expressions.add(new StringValue("")));
        this.build();

        final StringBuilder buffer = new StringBuilder();
        final ReplaceColumnValues expr = new ReplaceColumnValues(character);

        final SelectDeParser selectDeParser = new SelectDeParser(expr, buffer);
        expr.setSelectVisitor(selectDeParser);
        expr.setBuffer(buffer);

        final StatementDeParser stmt = new StatementDeParser(expr, selectDeParser, buffer);
        try {
            final Statement statement = CCJSqlParserUtil.parse(query);
            statement.accept(stmt);
        } catch (JSQLParserException exception) {
            exception.printStackTrace();
        }
        return stmt.getBuffer().toString();
    }

    public String build() {
        final Class<? extends Statement> queryClass = queryType.getQueryClass();
        try {
            this.statement = queryClass.newInstance();
        } catch (IllegalAccessException | InstantiationException exception) {
            exception.printStackTrace();
        }

        /*
         re-implementar um statementivisitoradapter
         para não precisar tratar cada tipo
         */

        return query;
    }
}