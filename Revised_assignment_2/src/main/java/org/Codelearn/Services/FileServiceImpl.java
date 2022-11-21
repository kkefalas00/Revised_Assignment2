package org.Codelearn.Services;

import java.io.FileNotFoundException;
import org.Codelearn.Repository.CsvRepository;
import org.Codelearn.Domain.Department;
import org.Codelearn.Domain.StudentDepartment;
import org.Codelearn.Domain.Student;

public class FileServiceImpl implements FileInterface{

    private String filename;

    public FileServiceImpl(){}

    public FileServiceImpl(String filename) {

        this.filename = filename;
    }


    @Override
    public void saveDepartment(String line) throws FileNotFoundException {
        CsvRepository.writeDepartmentToCsvFile(filename,line);

    }

    @Override
    public void saveStudent(String line) throws FileNotFoundException {
        CsvRepository.writeStudentToCsvFile(filename,line);
    }

    @Override
    public void saveStudentDepartment(String line) throws FileNotFoundException {

        CsvRepository.writeStudentDepartmentToCsvFile(filename,line);

    }


}
