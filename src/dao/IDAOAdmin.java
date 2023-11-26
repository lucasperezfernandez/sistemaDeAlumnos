package dao;

public interface IDAOAdmin<T >{
    /* Ejemplos tipo clase
    public void save(T element) throws DAOException;
    public void modify(T element) throws DAOException;
    public void delete(int id) throws DAOException;
    public T search(int id) throws DAOException;
    public ArrayList<T> searchAll() throws DAOException;
    */

    //Agregar un estudiante
    void addStudent(String password, String firstName, String lastName) throws DAOException;



    //Generar ID al crear usuario
    int generateUID();

    //Reporte General
    double generalReport();

    //Crear un curso.
    void addCourse(int courseId, String name, int capacity, int cost, int passingGrade, int professorId);

    //Reporte por cursos particualres
    void courseReport();
}
