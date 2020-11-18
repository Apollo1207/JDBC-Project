package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.EmergencyDetails;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmergencyDetailsDAO implements GeneralDAOInterface<EmergencyDetails, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.emergency_details";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.emergency_details WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.emergency_details "
            + "(id, type, cause) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.emergency_details"
            + " SET type=?, cause=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.emergency_details WHERE id=?";

    @Override
    public final List<EmergencyDetails> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<EmergencyDetails> emergencyDetailss = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String type = resultSet.getString(2);
                    String cause = resultSet.getString(3);
                    emergencyDetailss.add(new EmergencyDetails(id, type, cause));
                }
            }
        }
        return emergencyDetailss;
    }

    @Override
    public final EmergencyDetails getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        EmergencyDetails emergencyDetails = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String type = resultSet.getString(2);
                    String cause = resultSet.getString(3);
                    emergencyDetails = new EmergencyDetails(foundId, type, cause);
                }
            }
        }
        return emergencyDetails;
    }

    @Override
    public final int create(final EmergencyDetails entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getType());
            ps.setString(3, entity.getCause());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final EmergencyDetails entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getType());
            ps.setString(2, entity.getCause());
            ps.setInt(3, entity.getId());

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
