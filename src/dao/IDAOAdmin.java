package dao;

import entities.Form;

public interface IDAOAdmin<T >{
    /* Ejemplos tipo clase
    public void save(T element) throws DAOException;
    public void modify(T element) throws DAOException;
    public void delete(int id) throws DAOException;
    public T search(int id) throws DAOException;
    public ArrayList<T> searchAll() throws DAOException;
    */

    //Agregar un estudiante
    void addStudent(Form form ) throws DAOException;

    //Generar ID al crear usuario
    int generateUID();

    //Reporte General
    double generalReport();

    //Crear un curso.
    void addCourse(Form form);

    //Reporte por cursos particualres
    void courseReport();
}
