package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveOrUpdateUser(User user) {
        System.out.println("service "+user);
        userDAO.saveOrUpdateUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
}