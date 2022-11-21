package org.Codelearn.Repository;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRepository {

    private Connection connection;

    public DatabaseRepository(Connection connection){
        this.connection=connection;
    }



    public void CreateTableDepartment() throws SQLException{

        Statement statement= connection.createStatement();
       try {
           String sql = "CREATE TABLE if not exists department (\n" +
                   "    departmentid int  NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                   "    departmentname varchar(255) ,\n" +
                   "    numberoftracks int);";
           System.out.println(statement.executeUpdate(sql));
       }catch(SQLException e){
           System.out.println("Problem with SQL : " + e.getMessage());
       }


    }

    public void CreateTableStudent() throws SQLException{

        Statement statement= connection.createStatement();
        String sql="CREATE TABLE if not exists student (\n" +
                "    student_id int  NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                "    department_id int,\n" +
                "    student_name varchar(255),\n" +
                "    phone int,\n" +
                "    FOREIGN KEY (department_id) REFERENCES department(departmentid)\n" +
                ");";
        statement.executeUpdate(sql);
    }

}
