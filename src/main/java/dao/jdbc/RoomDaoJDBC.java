package dao.jdbc;

import dao.intefaces.RoomDao;
import factories.JDBCConnectionFactory;
import model.dto.NecessaryRoomDto;
import model.dto.RoomsAdminDto;
import model.entity.Room;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static enums.Attributes.PAGE_SIZE;

public class RoomDaoJDBC implements RoomDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public Room getNecessaryRoom(NecessaryRoomDto necessaryRoomDto, Connection connection) throws SQLException, ParseException {
        boolean smokeBool = false;
        boolean balconyBool = false;
        double priceFrom = 0;
        double priceTo = 1000;
        int roomType = 1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (necessaryRoomDto.getBalcony() != null && necessaryRoomDto.getBalcony().equals("on")) {
            balconyBool = true;
        }
        if (necessaryRoomDto.getSmoke() != null && necessaryRoomDto.getSmoke().equals("on")) {
            smokeBool = true;
        }

        switch (necessaryRoomDto.getPriceRange()) {
            case "0-90":
                priceTo = 90;
                break;
            case "0-180":
                priceTo = 180;
                break;
            case "0-300":
                priceTo = 300;
                break;
        }

        switch (necessaryRoomDto.getRoomTypeId().charAt(necessaryRoomDto.getRoomTypeId().length() - 1)) {
            case '2':
                roomType = 2;
                break;
            case '4':
                roomType = 3;
                break;
        }

        java.util.Date checkIn = dateFormat.parse(necessaryRoomDto.getDateIn());
        java.util.Date checkOut = dateFormat.parse(necessaryRoomDto.getDateOut());
        java.sql.Date dateFrom = new java.sql.Date(checkIn.getTime());
        java.sql.Date dateTo = new java.sql.Date(checkOut.getTime());

        String getNecessaryRoom = "SELECT * FROM rooms LEFT JOIN reservations ON rooms.room_id = reservations.room_id " +
                "WHERE rooms.balcony = ?" +
                " AND rooms.smoke = ?" +
                " AND rooms.room_type_id = ?" +
                " AND rooms.price BETWEEN ?" +
                " AND ? AND (? <reservations.date_in" +
                " AND ? <=reservations.date_in AND ? >=reservations.date_out AND ?>reservations.date_out AND ? NOT BETWEEN " +
                "reservations.date_in AND reservations.date_out AND ? NOT BETWEEN reservations.date_in AND reservations.date_out" +
                " OR reservations.room_id IS NULL)";

        statement = connection.prepareStatement(getNecessaryRoom);
        statement.setBoolean(1, balconyBool);
        statement.setBoolean(2, smokeBool);
        statement.setInt(3, roomType);
        statement.setDouble(4, priceFrom);
        statement.setDouble(5, priceTo);
        statement.setDate(6, dateFrom);
        statement.setDate(7, dateTo);
        statement.setDate(8, dateFrom);
        statement.setDate(9, dateTo);
        statement.setDate(10, dateFrom);
        statement.setDate(11, dateTo);

        resultSet = statement.executeQuery();

        Room room = null;

        if (resultSet.next()) {
            int roomId = resultSet.getInt("room_id");
            double price = resultSet.getDouble("price");
            room = new Room(roomId, price);
        }

        close();

        return room;
    }

    public RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException {
        String getAllRooms = "SELECT * FROM rooms LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllRooms);
        statement.setInt(1, Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) * (roomsAdminDto.getPage() - 1));
        resultSet = statement.executeQuery();

        List<Room> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("room_id");
            int number = resultSet.getInt("number");
            boolean balcony = resultSet.getBoolean("balcony");
            boolean smoke = resultSet.getBoolean("smoke");
            int roomTypeId = resultSet.getInt("room_type_id");
            double price = resultSet.getDouble("price");

            Room room = new Room(id, number, balcony, smoke, roomTypeId, price);
            list.add(room);
        }
        roomsAdminDto.setList(list);
        roomsAdminDto.setCount(count);
        close();
        return roomsAdminDto;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM rooms";
        statement = connection.prepareStatement(count);
        resultSet = statement.executeQuery();
        int total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt("total");
        }
        return total;
    }

    public void close() throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

