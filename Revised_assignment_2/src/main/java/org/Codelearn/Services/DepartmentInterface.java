package org.Codelearn.Services;


import org.Codelearn.Domain.Department;
import org.Codelearn.Domain.Student;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentInterface {

    public void createDepartment(Department department) throws SQLException;
    public void deleteDepartment(int id) throws SQLException;
    public Department findDepartment(int id) throws SQLException, DepartmentExceptions;
    public List findAllDepartments() throws SQLException, StudentExceptions, DepartmentExceptions;
    public void updateStudent(int id,String name) throws SQLException;


}
