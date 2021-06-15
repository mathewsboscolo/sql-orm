import dev.mathews.shared.annotation.Table;
import dev.mathews.shared.annotation.entity.Column;
import dev.mathews.shared.annotation.entity.Entity;
import dev.mathews.shared.annotation.id.GeneratedValue;
import dev.mathews.shared.annotation.id.Id;
import dev.mathews.shared.enumeration.GenerationType;

@Entity
@Table("table")
public class TestClass {

    @Id
    @GeneratedValue(generationType = GenerationType.AUTO)
    private long id;

    @Column("field1")
    private String field1;

    @Column("field2")
    private String field2;
}