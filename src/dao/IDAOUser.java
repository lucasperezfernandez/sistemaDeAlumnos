package dao;

import entities.User;

public interface IDAOUser {

    User validateLogin(int id, String password);



};
