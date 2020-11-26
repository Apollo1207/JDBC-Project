package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.CrewAccepted;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CrewAcceptedDAO implements GeneralDAOInterface<CrewAccepted, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.crew_accepted";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.crew_accepted WHERE id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.crew_accepted "
            + "(id, number, number_of_car, type_of_car, depature_time, arrive_time) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.crew_accepted"
            + " SET number=?, number_of_car=?, type_of_car=?, depature_time=?, arrive_time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.crew_accepted WHERE id=?";

    @Override
    public final List<CrewAccepted> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<CrewAccepted> crewAccepteds = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer number = resultSet.getInt(2);
                    String number_of_car = resultSet.getString(3);
                    String type_of_car = resultSet.getString(4);
                    String depature_time = resultSet.getString(5);
                    String arrive_time = resultSet.getString(6);
                    crewAccepteds.add(new CrewAccepted(id, number, number_of_car, type_of_car, depature_time, arrive_time));
                }
            }
        }
        return crewAccepteds;
    }

    @Override
    public final CrewAccepted getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CrewAccepted crewAccepted = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer number = resultSet.getInt(2);
                    String numberOfCar = resultSet.getString(3);
                    String typeOfCar = resultSet.getString(4);
                    String depatureTime = resultSet.getString(5);
                    String arriveTime = resultSet.getString(6);
                    crewAccepted = new CrewAccepted(foundId, number, numberOfCar, typeOfCar, depatureTime, arriveTime);
                }
            }
        }
        return crewAccepted;
    }

    @Override
    public final int create(final CrewAccepted entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getNumber());
            ps.setString(3, entity.getNumberOfCar());
            ps.setString(4, entity.getTypeOfCar());
            ps.setString(5, entity.getDepatureTime());
            ps.setString(6, entity.getArriveTime());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final CrewAccepted entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getNumber());
            ps.setString(2, entity.getNumberOfCar());
            ps.setString(3, entity.getTypeOfCar());
            ps.setString(4, entity.getDepatureTime());
            ps.setString(5, entity.getArriveTime());
            ps.setInt(6, entity.getId());

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

