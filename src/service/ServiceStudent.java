//package service;
//
//import dao.DAOException;
//import entidades.Student;
//
//import java.util.ArrayList;
//
//public class ServiceStudent {
//    private DAOStudent daoStudent;
//    public ServiceStudent()
//    {
//        daoStudent = new DAOStudent();
//    }
//    public void saveStudent(Student student) throws ServiceException
//    {
//        try {
//            daoStudent.save(student);
//        }
//        catch (DAOException e)
//        {
//            throw new ServiceException(e.getMessage());
//        }
//
//    }
//
//    public void modifyStudent(Student student) throws ServiceException
//    {
//        try{
//            daoStudent.modify(student);
//        }
//        catch (DAOException e)
//        {
//            throw  new ServiceException(e.getMessage());
//        }
//
//    }
//
//    public Student searchStudent(int id) throws  ServiceException
//    {
//        Student student = null;
//        try {
//            daoStudent.search(id);
//            return student;
//        }
//        catch (DAOException e)
//        {
//            throw new ServiceException(e.getMessage());
//        }
//
//    }
//
//    public void deleteStudent(int id) throws ServiceException
//    {
//        try{
//            daoStudent.delete(id);
//        }
//        catch (DAOException e)
//        {
//            throw  new ServiceException(e.getMessage());
//
//        }
//    }
//
//    public ArrayList<Student> everyStudent() throws ServiceException
//    {
//        ArrayList<Student> students;
//        try {
//            students=daoStudent.searchAll();
//            return students;
//        }
//        catch (DAOException e)
//        {
//            throw new ServiceException(e.getMessage());
//        }
//    }
//
//}
