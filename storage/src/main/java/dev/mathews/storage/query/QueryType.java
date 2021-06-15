package dev.mathews.storage.query;

import lombok.Getter;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;

public enum QueryType {

    CREATE_TABLE(CreateTable.class),
    INSERT(Insert.class),
    DELETE(Delete.class),
    REPLACE(Replace.class),
    UPDATE(Update.class),
    SELECT(Select.class);

    @Getter
    private final Class<? extends Statement> queryClass;

    QueryType(Class<? extends Statement> queryClass) {
        this.queryClass = queryClass;
    }
}
