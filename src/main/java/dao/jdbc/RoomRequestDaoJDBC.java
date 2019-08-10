package dao.jdbc;

import dao.intefaces.RoomRequestDao;
import factories.JDBCConnectionFactory;
import model.dto.RoomRequestDto;
import model.dto.RoomRequestsAdminDto;
import model.entity.RoomRequest;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static enums.Attributes.PAGE_SIZE;

public class RoomRequestDaoJDBC implements RoomRequestDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean addRequest(RoomRequestDto roomRequestDto) throws SQLException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int roomTypeId = 1;

        java.util.Date checkIn = dateFormat.parse(roomRequestDto.getDateIn());
        java.util.Date checkOut = dateFormat.parse(roomRequestDto.getDateOut());
        Date dateFrom = new Date(checkIn.getTime());
        Date dateTo = new Date(checkOut.getTime());

        switch (roomRequestDto.getRoomType().charAt(roomRequestDto.getRoomType().length() - 1)) {
            case '2':
                roomTypeId = 2;
                break;
            case '4':
                roomTypeId = 3;
                break;
        }

        String insertRequest = "INSERT INTO room_requests(room_type_id, date_in, date_out) VALUES (?,?,?)";
        connection = getConnection();
        statement = connection.prepareStatement(insertRequest, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, roomTypeId);
        statement.setDate(2, dateFrom);
        statement.setDate(3, dateTo);

        statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            close();
            return true;
        }
        close();
        return false;
    }

    @Override
    public RoomRequestsAdminDto getAllRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException {
        String getAllRequests = "SELECT * FROM room_requests LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllRequests);
        statement.setInt(1, Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) * (roomRequestsAdminDto.getPage()-1));
        resultSet = statement.executeQuery();

        List<RoomRequest> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("room_request_id");
            int roomTypeId = resultSet.getInt("room_type_id");
            Date dateIn = resultSet.getDate("date_in");
            Date dateOut = resultSet.getDate("date_out");
            RoomRequest roomRequest = new RoomRequest(id, roomTypeId, dateIn, dateOut);
            list.add(roomRequest);
        }
        roomRequestsAdminDto.setList(list);
        roomRequestsAdminDto.setCount(count);
        close();
        return roomRequestsAdminDto;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM room_requests";
        statement = connection.prepareStatement(count);
        resultSet = statement.executeQuery();
        int total = 0;
        if (resultSet.next()){
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
