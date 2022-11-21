package org.Codelearn.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.Codelearn.Domain.Department;
import org.Codelearn.Exceptions.DepartmentExceptions;


public class DepartmentRepository implements CrudInterface <Department> {

    private Connection connection;



    public DepartmentRepository (Connection connection){

        this.connection=connection;
    }


    @Override
    public void create(Department department) throws SQLException {

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO department(numberoftracks,departmentname) VALUES ('" + department.getNumberoftracks() + "','" + department.getDepartmentname() + "')";
        statement.executeUpdate(sql);
        System.out.println("department is inserted");

    }

    @Override
    public void update(int id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String sql="UPDATE department SET departmentname ='"+name +"'  WHERE departmentid="+id;
        statement.executeUpdate(sql);
        System.out.println("department is updated");

    }

    @Override
    public void delete(int id) throws SQLException {

        Statement statement = connection.createStatement();
        String sql="delete from department WHERE departmentid="+id;
        statement.executeUpdate(sql);
        System.out.println("Department with id"+id+" was deleted");

    }

    @Override
    public Department find(int id) throws SQLException, DepartmentExceptions {

        Statement statement = connection.createStatement();
        String sql = "select * from department where departmentid=" + id;
        ResultSet rs = statement.executeQuery(sql);
        Department department = null;
        if (rs.next()) {

            int department_id= Integer.parseInt(rs.getString("departmentid"));
            int numberOfTracks= Integer.parseInt(rs.getString("numberoftracks"));
            String departmentname = rs.getString("departmentname");

            department = new Department(numberOfTracks,departmentname);
        }
        rs.close();
        if (department == null) {
            throw new DepartmentExceptions("Cannot find department with id=" + id);
        }
        return department;
    }

    @Override
    public ArrayList<Department> findAll() throws SQLException, DepartmentExceptions {

        Statement statement = connection.createStatement();
        String sql = "select * from department";
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<Department> departments = new ArrayList<>();
        while (rs.next()) {

            int departmentId= Integer.parseInt(rs.getString("departmentid"));
            int numberOfTracks= Integer.parseInt(rs.getString("numberoftracks"));
            String departmentname = rs.getString("departmentname");

            Department d= new Department(numberOfTracks,departmentname);
            departments.add(d);
        }
        rs.close();
        if (departments == null) {
            throw new DepartmentExceptions("Cannot find any department");
        }
        return departments;


    }

    public String findALLDepartments() throws SQLException, DepartmentExceptions {


        Statement statement = connection.createStatement();
        String sql = "select * from department";
        ResultSet rs = statement.executeQuery(sql);
        String lineOfDepartments="";
        while (rs.next()) {

            int departmentId= Integer.parseInt(rs.getString("departmentid"));
            int numberOfTracks= Integer.parseInt(rs.getString("numberoftracks"));
            String departmentname = rs.getString("departmentname");

          lineOfDepartments+=departmentId+","+numberOfTracks+","+departmentname+"\n";
        }
        rs.close();
        if (lineOfDepartments == null) {
            throw new DepartmentExceptions("Cannot find any department");
        }
        return lineOfDepartments;

    }


}