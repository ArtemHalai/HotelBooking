package factories;

import command.*;
import command.admin_commands.*;
import enums.Mappings;

import java.util.HashMap;
import java.util.Map;

import static enums.Mappings.*;

public class CommandFactory {

    private static final Map<String, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(LOGIN_VIEW.getName(), new LoginCommand());
        commandMap.put(LOGGED_IN_VIEW.getName(), new LoggedInCommand());
        commandMap.put(REGISTRATION_VIEW.getName(), new RegistrationCommand());
        commandMap.put(BOOKING.getName(), new BookingCommand());
        commandMap.put(PAYMENT.getName(), new PaymentCommand());
        commandMap.put(GUEST_INFO.getName(), new GuestInfoCommand());
        commandMap.put(SUCCESSFUL.getName(), new SuccessfulCommand());
        commandMap.put(UNSUCCESSFUL.getName(), new UnsuccessfulCommand());
        commandMap.put(HOME.getName(), new HomeCommand());
        //admin commands
        commandMap.put(GUESTS_ADMIN.getName(), new GuestsCommand());
        commandMap.put(HOME_ADMIN.getName(), new HomeAdminCommand());
        commandMap.put(PAYMENTS_ADMIN.getName(), new PaymentsCommand());
        commandMap.put(ROOM_REQUESTS_ADMIN.getName(), new RoomRequestsCommand());
        commandMap.put(RESERVATIONS_ADMIN.getName(), new ReservationsCommand());
        commandMap.put(ROOMS_ADMIN.getName(), new RoomsCommand());
    }

    public static Command getCommand(String action) {
        return commandMap.getOrDefault(action, new HomeCommand());
    }

}
