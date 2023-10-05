package entities;

import dao.DAOStudent;

public class Student extends User {

    //Viejo enroll
//    public void enroll(int courseId, int id) {
//        DAOStudent daoStudent = new DAOStudent();
//        daoStudent.enroll(id, courseId);
//    }

    public void enroll(int courseId) {
        DAOStudent daoStudent = new DAOStudent();
        daoStudent.enroll(courseId, getUid());
    }

}