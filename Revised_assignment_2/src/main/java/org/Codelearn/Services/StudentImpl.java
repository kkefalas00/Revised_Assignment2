package org.Codelearn.Services;

import org.Codelearn.Domain.Student;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentDepartmentExceptions;
import org.Codelearn.Repository.StudentRepository;
import org.Codelearn.Exceptions.StudentExceptions;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class StudentImpl implements StudentInterface{

    private StudentRepository studentRepository;


    public StudentImpl(Connection connection) {

        studentRepository = new StudentRepository(connection);
    }


    @Override
    public void createStudent(Student student) throws SQLException {

        studentRepository.create(student);

    }

    @Override
    public void deleteStudent(int id) throws SQLException {

        studentRepository.delete(id);

    }

    @Override
    public Student findStudent(int id) throws SQLException, StudentExceptions, DepartmentExceptions {

        Student s=studentRepository.find(id);

        return s;
    }

    @Override
    public List findAllStudents() throws SQLException, StudentExceptions {
        List students=studentRepository.findAll();
        return students;
    }

    @Override
    public void updateStudent(int id, String name) throws SQLException {
        studentRepository.update(id,name);
    }

    public String getLinereport() throws StudentDepartmentExceptions, SQLException {
        String finalReport=studentRepository.findAllStudentsFromDepartments();
        return finalReport;
    }


}
