package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.InjuryOnCall;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class InjuryOnCallDAO implements GeneralDAOInterface<InjuryOnCall, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.injury_on_call";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.injury_on_call WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.injury_on_call "
            + "(id, name_of_injury, description_of_injury, number_of_hospital, diagnosis) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.injury_on_call"
            + " SET name_of_injury=?, description_of_injury=?, number_of_hospital=?, diagnosis=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.injury_on_call WHERE id=?";

    @Override
    public final List<InjuryOnCall> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<InjuryOnCall> injuryOnCalls = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name_of_injury = resultSet.getString(2);
                    String description_of_injury = resultSet.getString(3);
                    String number_of_hospital = resultSet.getString(4);
                    String diagnosis = resultSet.getString(5);
                    injuryOnCalls.add(new InjuryOnCall(id, name_of_injury, description_of_injury, number_of_hospital, diagnosis));
                }
            }
        }
        return injuryOnCalls;
    }

    @Override
    public final InjuryOnCall getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        InjuryOnCall injuryOnCall = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name_of_injury = resultSet.getString(2);
                    String description_of_injury = resultSet.getString(3);
                    String number_of_hospital = resultSet.getString(4);
                    String diagnosis = resultSet.getString(5);
                    injuryOnCall = new InjuryOnCall(foundId, name_of_injury, description_of_injury, number_of_hospital, diagnosis);
                }
            }
        }
        return injuryOnCall;
    }

    @Override
    public final int create(final InjuryOnCall entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getNameOfInjury());
            ps.setString(3, entity.getDescriptionOfInjury());
            ps.setString(4, entity.getNumberOfHospital());
            ps.setString(5, entity.getDiagnosis());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final InjuryOnCall entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getNameOfInjury());
            ps.setString(2, entity.getDescriptionOfInjury());
            ps.setString(3, entity.getNumberOfHospital());
            ps.setString(4, entity.getDiagnosis());
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
