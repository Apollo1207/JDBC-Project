package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.model.implementation.CrewAcceptedHasRescuerOfCrew;
import org.example.project.jdbc.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CrewAcceptedHasRescuerOfCrewDAO implements GeneralDAOInterface<CrewAcceptedHasRescuerOfCrew, Integer> {

    private static final String GET_ALL = "SELECT * FROM fedyniak_illya_db.crew_accepted_has_rescuer_of_crew";
    private static final String GET_BY_ID = "SELECT * FROM fedyniak_illya_db.crew_accepted_has_rescuer_of_crew WHERE crew_accepted_id=?";
    private static final String CREATE = "INSERT fedyniak_illya_db.crew_accepted_has_rescuer_of_crew "
            + "(crew_accepted_id, rescuer_of_crew_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE fedyniak_illya_db.crew_accepted_has_rescuer_of_crew"
            + " SET crew_accepted_id=?, rescuer_of_crew_id=? WHERE crew_accepted_id=?";
    private static final String DELETE = "DELETE FROM fedyniak_illya_db.crew_accepted_has_rescuer_of_crew WHERE crew_accepted_id=?";


    @Override
    public final List<CrewAcceptedHasRescuerOfCrew> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<CrewAcceptedHasRescuerOfCrew> crewAcceptedHasRescuerOfCrews = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer crewAcceptedId = resultSet.getInt(1);
                    Integer rescuerOfCrewId = resultSet.getInt(2);
                    crewAcceptedHasRescuerOfCrews.add(new CrewAcceptedHasRescuerOfCrew(crewAcceptedId, rescuerOfCrewId));
                }
            }
        }
        return crewAcceptedHasRescuerOfCrews;
    }

    @Override
    public final CrewAcceptedHasRescuerOfCrew getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CrewAcceptedHasRescuerOfCrew crewAcceptedHasRescuerOfCrew = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer rescuerOfCrewId = resultSet.getInt(2);
                    crewAcceptedHasRescuerOfCrew = new CrewAcceptedHasRescuerOfCrew(foundId, rescuerOfCrewId);
                }
            }
        }
        return crewAcceptedHasRescuerOfCrew;
    }

    @Override
    public final int create(final CrewAcceptedHasRescuerOfCrew entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getCrewAcceptedId());
            ps.setInt(2, entity.getRescuerOfCrewId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final CrewAcceptedHasRescuerOfCrew entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getRescuerOfCrewId());
            ps.setInt(2, entity.getCrewAcceptedId());

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
