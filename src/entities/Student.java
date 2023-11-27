package entities;

import dao.DAOStudent;

public class Student extends User {


    public void enroll(int courseId) {
        DAOStudent daoStudent = new DAOStudent();
        daoStudent.enroll(courseId, getUid());
    }

}