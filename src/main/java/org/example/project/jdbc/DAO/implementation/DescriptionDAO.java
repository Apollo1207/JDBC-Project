package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.Description;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DescriptionDAO implements GeneralDAOInterface<Description, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.description";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.description WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.description "
            + "(id, short_description, expanded_description, emergency_details_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.description"
            + " SET short_description=?, expanded_description=?, emergency_details_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.description WHERE id=?";

    @Override
    public final List<Description> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Description> descriptions = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String shortDescription = resultSet.getString(2);
                    String expandedDescription = resultSet.getString(3);
                    Integer emergencyDetailsId = resultSet.getInt(4);
                    descriptions.add(new Description(id, shortDescription, expandedDescription, emergencyDetailsId));
                }
            }
        }
        return descriptions;
    }

    @Override
    public final Description getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Description description = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String shortDescription = resultSet.getString(2);
                    String expandedDescription = resultSet.getString(3);
                    Integer emergencyDetailsId = resultSet.getInt(4);
                    description = new Description(foundId, shortDescription, expandedDescription, emergencyDetailsId);
                }
            }
        }
        return description;
    }

    @Override
    public final int create(final Description entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getShortDescription());
            ps.setString(3, entity.getExpandedDescription());
            ps.setInt(4, entity.getEmergencyDetailsId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Description entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getShortDescription());
            ps.setString(2, entity.getExpandedDescription());
            ps.setInt(3, entity.getEmergencyDetailsId());
            ps.setInt(4, entity.getId());

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