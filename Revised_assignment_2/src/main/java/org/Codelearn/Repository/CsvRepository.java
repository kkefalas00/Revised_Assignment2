package org.Codelearn.Repository;

import org.Codelearn.Domain.Department;
import org.Codelearn.Domain.Student;
import org.Codelearn.Domain.StudentDepartment;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.Codelearn.Repository.StudentRepository;
import org.Codelearn.Services.StudentImpl;
import org.Codelearn.Services.DepartmentImpl;

public class CsvRepository {

    public static void writeDepartmentToCsvFile(String filename, String line) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(line);
        pw.close();
    }


    public static void writeStudentToCsvFile(String filename, String line) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(line);
        pw.close();
    }

    public static void writeStudentDepartmentToCsvFile(String filename, String line) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(line);
        pw.close();
    }


}
