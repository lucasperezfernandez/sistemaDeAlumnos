package dao;

import java.util.ArrayList;

public interface IDAO <T >{
    public void save(T element) throws DAOException;
    public void modify(T element) throws DAOException;
    public void delete(int id) throws DAOException;
    public T search(int id) throws DAOException;
    public ArrayList<T> searchAll() throws DAOException;
}
