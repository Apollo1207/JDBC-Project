package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.service.GeneralServiceInterface;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralService<T> implements GeneralServiceInterface<T> {

    @Override
    public abstract GeneralDAOInterface<T, Integer> getDAO();

    @Override
    public List<T> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public T getById(Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public int create(T entity) throws SQLException {
        return getDAO().create(entity);
    }

    @Override
    public int update(T entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public int delete(Integer id) throws SQLException {
        return getDAO().delete(id);
    }

}