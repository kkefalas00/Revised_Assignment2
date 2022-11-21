package org.Codelearn.Services;

import org.Codelearn.Domain.Department;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;
import org.Codelearn.Repository.DepartmentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl implements DepartmentInterface{


    private DepartmentRepository departmentRepository;


    public DepartmentImpl(Connection connection) {

        departmentRepository = new DepartmentRepository(connection);
    }

    @Override
    public void createDepartment(Department department) throws SQLException {

        departmentRepository.create(department);

    }

    @Override
    public void deleteDepartment(int id) throws SQLException {

        departmentRepository.delete(id);

    }

    @Override
    public Department findDepartment(int id) throws SQLException, DepartmentExceptions {
        Department d =departmentRepository.find(id);
        return d;
    }

    @Override
    public ArrayList<Department> findAllDepartments() throws SQLException, StudentExceptions, DepartmentExceptions {
        ArrayList departments=departmentRepository.findAll();
        return departments;
    }

    @Override
    public void updateStudent(int id, String name) throws SQLException {
        departmentRepository.update(id,name);
    }

    public String findAllDeparts() throws SQLException, DepartmentExceptions {

        String alldeparts= departmentRepository.findALLDepartments();
        return alldeparts;
    }
}
