package dao;

import entities.Form;

public interface IDAOAdmin{
    void addStudent(Form form ) throws DAOException;

    int generateUID();

    double generalReport();

    void addCourse(Form form);

    void courseReport();
}
