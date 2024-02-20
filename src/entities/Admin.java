package entities;

import dao.DAOException;
import dao.IDAOAdmin;
public class Admin extends User {
    private final IDAOAdmin daoAdmin;

    // Constructor
    public Admin(IDAOAdmin daoAdmin) {
        this.daoAdmin = daoAdmin;
    }


    public void addStudent(Form form) {
        try {
            daoAdmin.addStudent(form);
            System.out.println("Student added: " + form.getFirstName() + " " + form.getLastName());
        } catch (DAOException e) {
            // Manejo la exception aca mandando mensaje de error.
            System.err.println("Error adding student: " + e.getMessage());
        }
    }
    public double generalReport() {
        return daoAdmin.generalReport();
    }




    public void addCourse(Form form) {
        daoAdmin.addCourse(form);
    }



    //////////////////////////////////REVEER, POR AHI CREAR OBJETO CURSO PARA SACAR LA DATA/////////////////////////////////////////////

    public void courseReport() {
        daoAdmin.courseReport();
    }


}
