package org.Codelearn.Domain;

public class Department {

    private int departmentid;
    private int numberoftracks;
    private String departmentname;


    public Department(int numberoftracks,String departmentname){
        this.numberoftracks=numberoftracks;
        this.departmentname=departmentname;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getNumberoftracks() {
        return numberoftracks;
    }

    public void setNumberoftracks(int numberoftracks) {
        this.numberoftracks = numberoftracks;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", numberoftracks=" + numberoftracks +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }



}
