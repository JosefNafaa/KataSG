import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {
    ArrayList<Statement> statements;

    @Before
    public void init() {
        statements = new ArrayList<Statement>();
    }

    @Test
    public void when_adding_new_statement_then_statements_should_contains_the_statement_line() {
        //given when
        Statement statement = new Statement(AccountConstants.DEPOSIT, new Date(), 100, 1000);
        statements.add(statement);
        //then

        assertThat(statements).containsExactly(statement);
    }
}
