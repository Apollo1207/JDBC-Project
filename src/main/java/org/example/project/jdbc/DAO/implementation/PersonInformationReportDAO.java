package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.PersonInformationReport;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonInformationReportDAO implements GeneralDAOInterface<PersonInformationReport, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.person_information_report";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.person_information_report WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.person_information_report "
            + "(id, name, last_name, phone_number) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.person_information_report"
            + " SET name=?, last_name=?, phone_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.person_information_report WHERE id=?";

    @Override
    public final List<PersonInformationReport> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PersonInformationReport> personInformationReports = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String phoneNumber = resultSet.getString(4);
                    personInformationReports.add(new PersonInformationReport(id, name, lastName, phoneNumber));
                }
            }
        }
        return personInformationReports;
    }

    @Override
    public final PersonInformationReport getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PersonInformationReport personInformationReports = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String phoneNumber = resultSet.getString(4);
                    personInformationReports = new PersonInformationReport(foundId, name, lastName, phoneNumber);
                }
            }
        }
        return personInformationReports;
    }

    @Override
    public final int create(final PersonInformationReport entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getPhoneNumber());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PersonInformationReport entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPhoneNumber());
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

