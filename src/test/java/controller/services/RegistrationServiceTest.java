package controller.services;

import dao.intefaces.GuestDao;
import enums.Role;
import factories.JDBCConnectionFactory;
import model.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    @Mock
    private GuestDao guestDao;

    @InjectMocks
    private RegistrationService service;

    @Test
    public void registerGuest() throws SQLException {
        Guest guest = new Guest("Alex", "Petrov", 30, "+380934567894", "HY249083",
                "ivanpetrov", "12345678");
        guest.setRole(Role.GUEST);
        Connection connection = spy(JDBCConnectionFactory.getInstance().getConnection());
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);

        service.registerGuest(guest, connection);
        verify(guestDao).usernameExists(guest, connection);
        verify(guestDao).addRegisteredGuest(guest, connection);
    }
}