package org.Codelearn.Services;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public interface FileInterface {

    public void saveDepartment(String line) throws FileNotFoundException;
    public void saveStudent(String line) throws FileNotFoundException;
    public void saveStudentDepartment(String line) throws FileNotFoundException;

}
