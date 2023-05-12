package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveOrUpdateUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
