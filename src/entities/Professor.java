package entities;

import dao.DAOProfessor;

public class Professor extends User{

    //public void addInfo();
    //public void addGrade();
    public void addGrade(int grade, int studentId) {
        DAOProfessor daoProfessor = new DAOProfessor();
        daoProfessor.addGrade(grade, studentId, getUid());
    }


    public void addInfo(String information) {
        DAOProfessor daoProfessor = new DAOProfessor();
        daoProfessor.addInfo(information, getUid());
    }

}
