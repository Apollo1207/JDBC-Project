package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.ReceivedCall;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReceivedCallDAO implements GeneralDAOInterface<ReceivedCall, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.received_call";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.received_call WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.received_call "
            + "(id, description_id, address, person_information_report_id, datetime) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.received_call"
            + " SET description_id=?, address=?, person_information_report_id=?, datetime=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.received_call WHERE id=?";

    @Override
    public final List<ReceivedCall> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<ReceivedCall> receivedCalls = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer descriptionId = resultSet.getInt(2);
                    String address = resultSet.getString(3);
                    Integer personInformationId = resultSet.getInt(4);
                    String dateTime = resultSet.getString(5);
                    receivedCalls.add(new ReceivedCall(id, descriptionId, address, personInformationId, dateTime));
                }
            }
        }
        return receivedCalls;
    }

    @Override
    public final ReceivedCall getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        ReceivedCall receivedCall = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer descriptionId = resultSet.getInt(2);
                    String address = resultSet.getString(3);
                    Integer personInformationId = resultSet.getInt(4);
                    String dateTime = resultSet.getString(5);
                    receivedCall = new ReceivedCall(foundId, descriptionId, address, personInformationId, dateTime);
                }
            }
        }
        return receivedCall;
    }

    @Override
    public final int create(final ReceivedCall entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getDescriptionId());
            ps.setString(3, entity.getAddress());
            ps.setInt(4, entity.getPersonInformationReportId());
            ps.setString(5, entity.getDatetime());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final ReceivedCall entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getDescriptionId());
            ps.setString(2, entity.getAddress());
            ps.setInt(3, entity.getPersonInformationReportId());
            ps.setString(4, entity.getDatetime());
            ps.setInt(5, entity.getId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);

            return ps.executeUpdate();
        }
    }
}
