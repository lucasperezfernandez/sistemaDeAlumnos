package entities;

import dao.DAOAdmin;

public class Admin extends User {
    private DAOAdmin daoAdmin;

    // Constructor
    public Admin() {
        this.daoAdmin = new DAOAdmin(); // Instancia DAOAdmin
    }


    // Metodo para agregar estudiante. Por ahi pasar el formulario omo objeto, y no tantos parametros.
    public void addStudent(Form form) {
        daoAdmin.addStudent(form);
        System.out.println("Student added: " + form.getFirstName() + " " + form.getLastName());
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
