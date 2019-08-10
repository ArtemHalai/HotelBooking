package factories;

import command.*;
import command.admin_commands.*;
import enums.Mappings;

import java.util.HashMap;
import java.util.Map;
public class CommandFactory {

    private static final Map<String, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(Mappings.LOGIN_VIEW.getName(), new LoginCommand());
        commandMap.put(Mappings.LOGGED_IN_VIEW.getName(), new LoggedInCommand());
        commandMap.put(Mappings.REGISTRATION_VIEW.getName(), new RegistrationCommand());
        commandMap.put(Mappings.BOOKING.getName(), new BookingCommand());
        commandMap.put(Mappings.PAYMENT.getName(), new PaymentCommand());
        commandMap.put(Mappings.GUEST_INFO.getName(), new GuestInfoCommand());
        commandMap.put(Mappings.SUCCESSFUL.getName(), new SuccessfulCommand());
        commandMap.put(Mappings.UNSUCCESSFUL.getName(), new UnsuccessfulCommand());
        commandMap.put(Mappings.HOME.getName(), new HomeCommand());
        //admin commands
        commandMap.put(Mappings.GUESTS_ADMIN.getName(), new GuestsCommand());
        commandMap.put(Mappings.HOME_ADMIN.getName(), new HomeAdminCommand());
        commandMap.put(Mappings.PAYMENTS_ADMIN.getName(), new PaymentsCommand());
        commandMap.put(Mappings.ROOM_REQUESTS_ADMIN.getName(), new RoomRequestsCommand());
        commandMap.put(Mappings.RESERVATIONS_ADMIN.getName(), new ReservationsCommand());
        commandMap.put(Mappings.ROOMS_ADMIN.getName(), new RoomsCommand());
    }

    public static Command getCommand(String action) {
        return commandMap.getOrDefault(action, new HomeCommand());
    }

}
