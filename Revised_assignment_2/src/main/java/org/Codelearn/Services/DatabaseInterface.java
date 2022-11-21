package org.Codelearn.Services;

import org.Codelearn.Exceptions.DatabaseExceptions;

import java.sql.SQLException;

public interface DatabaseInterface {

    public void createStudentTable() throws SQLException;
    public void createDepartmentTable() throws SQLException;

}
