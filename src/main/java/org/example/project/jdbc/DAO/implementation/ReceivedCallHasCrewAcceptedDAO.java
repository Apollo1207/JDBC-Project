package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.ReceivedCallHasCrewAccepted;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class ReceivedCallHasCrewAcceptedDAO implements GeneralDAOInterface<ReceivedCallHasCrewAccepted, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.received_call_has_crew_accepted";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.received_call_has_crew_accepted WHERE received_call_id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.received_call_has_crew_accepted "
            + "(received_call_id, crew_accepted_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.received_call_has_crew_accepted"
            + " SET received_call_id=?, crew_accepted_id=? WHERE received_call_id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.received_call_has_crew_accepted WHERE received_call_id=?";


    @Override
    public final List<ReceivedCallHasCrewAccepted> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<ReceivedCallHasCrewAccepted> receivedCallHasCrewAccepteds = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer receivedCallId = resultSet.getInt(1);
                    Integer rescuerOfCrewId = resultSet.getInt(2);
                    receivedCallHasCrewAccepteds.add(new ReceivedCallHasCrewAccepted(receivedCallId, rescuerOfCrewId));
                }
            }
        }

        return receivedCallHasCrewAccepteds;
    }

    @Override
    public final ReceivedCallHasCrewAccepted getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        ReceivedCallHasCrewAccepted receivedCallHasCrewAccepted = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer rescuerOfCrewId = resultSet.getInt(2);
                    receivedCallHasCrewAccepted = new ReceivedCallHasCrewAccepted(foundId, rescuerOfCrewId);
                }
            }
        }

        return receivedCallHasCrewAccepted;
    }

    @Override
    public final int create(final ReceivedCallHasCrewAccepted entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getReceivedCallId());
            ps.setInt(2, entity.getCrewAcceptedId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final ReceivedCallHasCrewAccepted entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getCrewAcceptedId());
            ps.setInt(2, entity.getReceivedCallId());

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
