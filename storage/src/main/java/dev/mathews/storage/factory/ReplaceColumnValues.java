package dev.mathews.storage.factory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReplaceColumnValues extends ExpressionDeParser {

    private final String append;

    @Override
    public void visit(StringValue stringValue) {
        getBuffer().append(append);
    }

    @Override
    public void visit(LongValue longValue) {
        getBuffer().append(append);
    }
}
