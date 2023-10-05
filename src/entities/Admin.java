package entities;

import dao.DAOAdmin;

public class Admin extends User {
    private DAOAdmin daoAdmin;

    // Constructor for the Admin class
    public Admin() {
        this.daoAdmin = new DAOAdmin(); // Instantiate DAOAdmin
    }

    // Method to add a student
    public void addStudent(String password, String firstName, String lastName) {
        daoAdmin.addStudent(password, firstName, lastName);
        System.out.println("Student added: " + firstName + " " + lastName);
    }

    public double generalReport() {
        return daoAdmin.generalReport();
    }

    public void addCourse(int courseId, String name, int capacity, int cost, int passingGrade, int professorId) {
        daoAdmin.addCourse(courseId, name, capacity, cost, passingGrade, professorId);
    }




    //////////////////////////////////REVEER, POR AHI CREAR OBJETO CURSO PARA SACR LA DATA/////////////////////////////////////////////

    public void courseReport() {
        daoAdmin.courseReport();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
