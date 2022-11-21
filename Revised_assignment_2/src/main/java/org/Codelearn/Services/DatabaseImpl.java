package org.Codelearn.Services;

import org.Codelearn.Repository.DatabaseRepository;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseImpl implements DatabaseInterface{

    private DatabaseRepository databaseRepository;

    public DatabaseImpl(Connection connection) {

        databaseRepository = new DatabaseRepository(connection);
    }

    @Override
    public void createDepartmentTable() throws SQLException {
        databaseRepository.CreateTableDepartment();

    }

    @Override
    public void createStudentTable() throws SQLException {
        databaseRepository.CreateTableStudent();
    }


}
