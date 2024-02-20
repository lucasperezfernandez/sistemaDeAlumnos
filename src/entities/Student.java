package entities;

import dao.IDAOStudent;

public class Student extends User {
    private final IDAOStudent daoStudent;

    // Constructor que recibe una instancia de la interfaz IDAOStudent
    public Student(IDAOStudent daoStudent) {
        this.daoStudent = daoStudent;
    }

    public void enroll(int courseId) {
        daoStudent.enroll(courseId, getUid());
    }

    public void inscriptionsReport() {
        daoStudent.inscriptionsReport(getUid());
    }
}
