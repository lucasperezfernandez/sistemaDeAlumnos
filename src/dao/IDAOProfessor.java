package dao;

public interface IDAOProfessor {

    // Metodo para agregar Notas a un estudiante segun id
    void addGrade(int grade, int studentId, int professorId);

    //Metodo para agregar cierta inforamción al curso que da el profesor.
    void addInfo(String information, int professorId);


}
