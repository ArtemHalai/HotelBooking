package exceptions;

import java.sql.SQLException;

public class DBException extends SQLException {
    public DBException(SQLException e) {
        super(e);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(String message) {
        super(message);
    }
}
