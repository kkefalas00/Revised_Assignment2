package org.Codelearn.Services;

import org.Codelearn.Domain.Student;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    public void createStudent(Student student) throws SQLException;
    public void deleteStudent(int id) throws SQLException;
    public Student findStudent(int id) throws SQLException, StudentExceptions, DepartmentExceptions;
    public List findAllStudents() throws SQLException, StudentExceptions;
    public void updateStudent(int id,String name) throws SQLException;
}
