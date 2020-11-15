package org.example.project.jdbc.DAO.implementation;


import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.RescuerOfCrew;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class RescuerOfCrewDAO implements GeneralDAOInterface<RescuerOfCrew, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.rescuer_of_crew";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.rescuer_of_crew WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.rescuer_of_crew "
            + "(id, name, last_name, sur_name, number_of_token, rank_position, date_of_birth, address_of_residence, injury_on_call_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.rescuer_of_crew"
            + " SET name=?, last_name=?, sur_name=?, number_of_token=?, rank_position=?, date_of_birth=?, address_of_residence=?, injury_on_call_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.rescuer_of_crew WHERE id=?";

    @Override
    public final List<RescuerOfCrew> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<RescuerOfCrew> rescuerOfCrews = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String surName = resultSet.getString(4);
                    Integer numberOfToken = resultSet.getInt(5);
                    String rankPosition = resultSet.getString(6);
                    String dateOfBirth = resultSet.getString(7);
                    String addressOfResidence = resultSet.getString(8);
                    Integer injuryOnCallId = resultSet.getInt(9);
                    rescuerOfCrews.add(new RescuerOfCrew(id, name, lastName, surName, numberOfToken, rankPosition, dateOfBirth, addressOfResidence, injuryOnCallId));
                }
            }
        }
        return rescuerOfCrews;
    }

    @Override
    public final RescuerOfCrew getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RescuerOfCrew rescuerOfCrew = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String surName = resultSet.getString(4);
                    Integer numberOfToken = resultSet.getInt(5);
                    String rankPosition = resultSet.getString(6);
                    String dateOfBirth = resultSet.getString(7);
                    String addressOfResidence = resultSet.getString(8);
                    Integer injuryOnCallId = resultSet.getInt(9);
                    rescuerOfCrew = new RescuerOfCrew(foundId, name, lastName, surName, numberOfToken, rankPosition, dateOfBirth, addressOfResidence, injuryOnCallId);
                }
            }
        }
        return rescuerOfCrew;
    }

    @Override
    public final int create(final RescuerOfCrew entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getSurName());
            ps.setInt(5, entity.getNumberOfToken());
            ps.setString(6, entity.getRankPosition());
            ps.setString(7, entity.getDateOfBirth());
            ps.setString(8, entity.getAddressOfResidence());
            ps.setInt(9, entity.getInjuryOnCallId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final RescuerOfCrew entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getSurName());
            ps.setInt(4, entity.getNumberOfToken());
            ps.setString(5, entity.getRankPosition());
            ps.setString(6, entity.getDateOfBirth());
            ps.setString(7, entity.getAddressOfResidence());
            ps.setInt(8, entity.getInjuryOnCallId());
            ps.setInt(9, entity.getId());

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
