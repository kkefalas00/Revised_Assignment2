package org.Codelearn.CompleteAssignment_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.Codelearn.Domain.Department;
import org.Codelearn.Domain.Student;
import org.Codelearn.Exceptions.DepartmentExceptions;
import org.Codelearn.Exceptions.StudentDepartmentExceptions;
import org.Codelearn.Exceptions.StudentExceptions;
import org.Codelearn.Services.*;

public class Main {

    private static Connection connection = null;
    private static Properties dbProperties = null;

    public static void main(String[] args) {
        initiateDatabase();
        runBusiness();
    }

    public static void runBusiness()  {

        try{
            CreateTableForDepartment();
            CreateTableForStudent();
//            Department d1 = new Department(Integer.parseInt(dbProperties.getProperty("create.numberoftracks1")),dbProperties.getProperty("create.departmentname1"));
//            Department d2 = new Department(Integer.parseInt(dbProperties.getProperty("create.numberoftracks2")),dbProperties.getProperty("create.departmentname2"));
//            Department d3 = new Department(Integer.parseInt(dbProperties.getProperty("create.numberoftracks3")),dbProperties.getProperty("create.departmentname3"));
//            d1.setDepartmentid(1);
//            d2.setDepartmentid(2);
//            d3.setDepartmentid(3);
//            CreateDepartments(d1);
//            CreateDepartments(d2);
//            CreateDepartments(d3);

//            Student st1 = new Student(Integer.parseInt(dbProperties.getProperty("create.student1.departmentId")),dbProperties.getProperty("create.student1.name"),Integer.parseInt(dbProperties.getProperty("create.student1.phone")));
//            Student st2 = new Student(Integer.parseInt(dbProperties.getProperty("create.student2.departmentId")),dbProperties.getProperty("create.student2.name"),Integer.parseInt(dbProperties.getProperty("create.student2.phone")));
//            Student st3 = new Student(Integer.parseInt(dbProperties.getProperty("create.student3.departmentId")),dbProperties.getProperty("create.student3.name"),Integer.parseInt(dbProperties.getProperty("create.student3.phone")));
//
//            st1.setStudent_id(1);
//            st2.setStudent_id(2);
//            st3.setStudent_id(3);
//
//            CreateStudent(st1);
//            CreateStudent(st2);
//            CreateStudent(st3);
            ArrayList departs=new ArrayList();
            departs= getAllDepartments();
            System.out.println(departs.toString());

            //updateDepartmentName(Integer.parseInt(dbProperties.getProperty("update.departmentId2")),dbProperties.getProperty("update.department2"));
//            deleteHistoryDepartment(Integer.parseInt(dbProperties.getProperty("delete.history.Id")));
            //updateStudent(Integer.parseInt(dbProperties.getProperty("update.id.student")),dbProperties.getProperty("update.student.name"));
            //System.out.println(findStudent(Integer.parseInt(dbProperties.getProperty("find.student.id"))));
//            String line=getTheDepartments();
//            saveDepartmentToFile(line);
            String finalline=saveStudentsDepartments();
            saveStudentsDepapartmentsToFile(finalline);

        }catch(SQLException  e) {
           System.out.println("Problem with SQL : " + e.getMessage());
        }catch(StudentExceptions | StudentDepartmentExceptions e){
            System.out.println("Problem with Student : " + e.getMessage());
        }catch(DepartmentExceptions  e){
            System.out.println("Problem with Department : " + e.getMessage());
        }catch(FileNotFoundException e){
            System.out.println("Problem with File : " + e.getMessage());
        }
    }

    private static void initiateDatabase() {
        try {
            readProperties();
            useMySqlDriver();
            connectToDatabase(dbProperties.getProperty("connection.schema"));
            //System.out.println("connected");
        } catch (SQLException e) {
            System.out.println("Problem with system SQL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem with system file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Problem with system: " + e.getMessage());
        }
    }

    private static void readProperties() throws IOException {
        InputStream inStream = Main.class.getClassLoader().getResourceAsStream("sql.properties");
        dbProperties = new Properties();
        dbProperties.load(inStream);
    }

    private static void useMySqlDriver() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    }

    private static Connection connectToDatabase(String schema) throws SQLException {
        String dbUrl = dbProperties.getProperty("connection.url");
        String username = dbProperties.getProperty("connection.username");
        String password = dbProperties.getProperty("connection.password");
        connection = DriverManager.getConnection(dbUrl + "/" + schema, username, password);
        return connection;
    }

    private static void CreateTableForDepartment() throws SQLException {

        DatabaseImpl  service = new DatabaseImpl(connection);
        service.createDepartmentTable();

    }

    private static void CreateTableForStudent() throws SQLException {
        DatabaseImpl  service = new DatabaseImpl(connection);
        service.createStudentTable();
    }

    private static void CreateDepartments(Department department) throws SQLException {
        DepartmentImpl service = new DepartmentImpl(connection);
        service.createDepartment(department);
    }

    private static ArrayList getAllDepartments() throws SQLException, StudentExceptions, DepartmentExceptions {
        ArrayList departments = new ArrayList();
        DepartmentImpl service = new DepartmentImpl(connection);
        departments=service.findAllDepartments();
        return  departments;
    }

    private static void updateDepartmentName(int id, String name) throws SQLException {
        DepartmentImpl service = new DepartmentImpl(connection);
        service.updateStudent(id,name);
    }

    private static void deleteHistoryDepartment(int id) throws SQLException {
        DepartmentImpl service = new DepartmentImpl(connection);
        service.deleteDepartment(id);
    }


    private static void CreateStudent(Student student) throws SQLException {
       StudentImpl service= new StudentImpl(connection);
        service.createStudent(student);
    }

    private static void updateStudent(int id,String name) throws SQLException {
        StudentImpl service= new StudentImpl(connection);
        service.updateStudent(id,name);
    }

    private static Student findStudent(int id) throws SQLException, StudentExceptions, DepartmentExceptions {

        StudentImpl service= new StudentImpl(connection);
        Student student=  service.findStudent(id);
        return student;

    }

    private static String getTheDepartments() throws SQLException, DepartmentExceptions {
        DepartmentImpl service = new DepartmentImpl(connection);
        String allDepartLine=service.findAllDeparts();
        return allDepartLine;
    }

    private static void saveDepartmentToFile(String line) throws FileNotFoundException, SQLException,DepartmentExceptions {
        DepartmentImpl service = new DepartmentImpl(connection);
        String allDepartments =service.findAllDeparts();
       FileServiceImpl fs = new FileServiceImpl("data\\departments.csv");
        fs.saveDepartment(allDepartments);
    }

    private static String saveStudentsDepartments() throws StudentDepartmentExceptions, SQLException {
        StudentImpl service= new StudentImpl(connection);
        String finalreport=service.getLinereport();
        return finalreport;
    }

    private static void saveStudentsDepapartmentsToFile(String line) throws StudentDepartmentExceptions, SQLException, FileNotFoundException {
        StudentImpl service= new StudentImpl(connection);
        String fnreport=service.getLinereport();
        FileServiceImpl fs = new FileServiceImpl("data\\finalreport.csv");
        fs.saveStudentDepartment(fnreport);
    }




}