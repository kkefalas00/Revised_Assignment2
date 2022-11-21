package org.Codelearn.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.Codelearn.Domain.Student;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;
import org.Codelearn.Exceptions.StudentDepartmentExceptions;
import org.Codelearn.Domain.Department;

public class StudentRepository implements CrudInterface <Student>{

    private Connection connection;
    private List<Student> students;
    private String lineOfReport="";

    public StudentRepository (Connection connection){
        this.connection=connection;
    }


    @Override
    public void create(Student student) throws SQLException {

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO student(department_id,student_name,phone) VALUES ('" + student.getDepartment_id() + "','" + student.getName() + "','" + student.getPhone()+"')";
        statement.executeUpdate(sql);
        System.out.println("student is inserted");

    }

    @Override
    public void update(int id, String name) throws SQLException {

        Statement statement = connection.createStatement();
        String sql="UPDATE student SET student_name ='"+name +"' WHERE student_id="+id;
        statement.executeUpdate(sql);
        System.out.println("student is updated");

    }

    @Override
    public void delete(int id) throws SQLException {

        Statement statement = connection.createStatement();
        String sql="delete from student WHERE student_id="+id;
        statement.executeUpdate(sql);
        System.out.println("student with id"+id+" was deleted");

    }

    @Override
    public Student find(int id) throws SQLException, DepartmentExceptions, StudentExceptions {

        Statement statement = connection.createStatement();
        String sql = "select * from student where student_id="+id;
        ResultSet rs = statement.executeQuery(sql);
        Student student = null;
        if (rs.next()) {

            int departmentId= Integer.parseInt(rs.getString("department_id"));
            String name = rs.getString("student_name");
            int phone= Integer.parseInt(rs.getString("phone"));

            student = new Student(departmentId,name,phone);

        }
        rs.close();
        if (student == null) {
            throw new StudentExceptions("Cannot find Student with id=" + id);
        }
        return student;
    }

    @Override
    public List<Student> findAll() throws SQLException, StudentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select * from student";
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {

            int student_id= Integer.parseInt(rs.getString("student_id"));
            int department_id= Integer.parseInt(rs.getString("department_id"));
            String name = rs.getString("student_name");
            int phone= Integer.parseInt(rs.getString("phone"));

            Student s = new Student(department_id,name,phone);
            students.add(s);
        }
        rs.close();
        if (students == null) {
            throw new StudentExceptions("Cannot find any student");
        }
        return students;
    }


    public String findAllStudentsFromDepartments() throws SQLException, StudentDepartmentExceptions {
        Statement statement = connection.createStatement();
        String sql = "select student_name,departmentname,department_id from department,student where departmentid=department_id";
        ResultSet rs = statement.executeQuery(sql);


        while (rs.next()) {

            String nameStudent= rs.getString("student_name");
            String departmentname = rs.getString("departmentname");

            lineOfReport+=nameStudent+","+departmentname+"\n";
        }
        rs.close();
        if (lineOfReport == null) {
            throw new StudentDepartmentExceptions("Cannot find any department");
        }
        return lineOfReport;

    }



}
