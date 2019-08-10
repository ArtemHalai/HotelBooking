package factories;

import dao.intefaces.*;
import dao.jdbc.*;

public class DaoFactory {
    private static volatile DaoFactory factory = null;

    private DaoFactory(){

    }

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

    public RoomDao getRoomDao() {
        return new RoomDaoJDBC();
    }

    public GuestDao getGuestDao() {
        return new GuestDaoJDBC();
    }

    public RoomRequestDao getRoomRequestDao() {
        return new RoomRequestDaoJDBC();
    }

    public PaymentDao getPaymentDao() {
        return new PaymentDaoJDBC();
    }

    public ReservationDao getReservationDao() {
        return new ReservationDaoJDBC();
    }
}
