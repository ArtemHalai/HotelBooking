import factories.JDBCConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionFactoryTest {

    @Test
    public void getConnection() throws SQLException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        assertTrue(connection.isValid(1));
    }
}