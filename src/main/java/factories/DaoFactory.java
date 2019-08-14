package factories;

import dao.intefaces.*;
import dao.jdbc.*;

/**
 * A class that provides factory to get dao implementation.
 */
public class DaoFactory {

    /**
     * Static instance of this class.
     */
    private static volatile DaoFactory factory = null;

    /**
     * Private constructor to prevent
     * the instantiation of this class directly
     */
    private DaoFactory() {

    }

    /**
     * Gets the instance of factory.
     *
     * @return the instance of {@link #factory}.
     */
    public static DaoFactory getInstance() {
        if (factory == null) {
            synchronized (DaoFactory.class) {
                if (factory == null) {
                    factory = new DaoFactory();
                }
            }
        }
        return factory;
    }

    /**
     * Gets the RoomDao implementation.
     *
     * @return the instance of RoomDao implementation.
     */
    public RoomDao getRoomDao() {
        return new RoomDaoJDBC();
    }

    /**
     * Gets the GuestDao implementation.
     *
     * @return the instance of GuestDao implementation.
     */
    public GuestDao getGuestDao() {
        return new GuestDaoJDBC();
    }

    /**
     * Gets the RoomRequestDao implementation.
     *
     * @return the instance of RoomRequestDao implementation.
     */
    public RoomRequestDao getRoomRequestDao() {
        return new RoomRequestDaoJDBC();
    }

    /**
     * Gets the PaymentDao implementation.
     *
     * @return the instance of PaymentDao implementation.
     */
    public PaymentDao getPaymentDao() {
        return new PaymentDaoJDBC();
    }

    /**
     * Gets the ReservationDao implementation.
     *
     * @return the instance of ReservationDao implementation.
     */
    public ReservationDao getReservationDao() {
        return new ReservationDaoJDBC();
    }
}
