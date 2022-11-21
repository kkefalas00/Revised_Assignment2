package org.Codelearn.Repository;

import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;

import java.sql.SQLException;
import java.util.List;

public interface CrudInterface<T> {
    public void create(T t) throws SQLException;
    public void update(int id, String name) throws SQLException;
    public void delete(int id) throws SQLException;
    public T find(int id) throws SQLException, DepartmentExceptions, StudentExceptions;
    public List<T> findAll() throws SQLException, DepartmentExceptions, StudentExceptions;


}
