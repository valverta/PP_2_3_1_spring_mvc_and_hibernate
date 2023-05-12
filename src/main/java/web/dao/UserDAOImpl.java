package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory managerFactory;

    @Override
    public List<User> getAllUsers() {
        managerFactory.createEntityManager().merge(new User("Ahtak", "Znachit", 69));
        return managerFactory.createEntityManager().createQuery("FROM User").getResultList();
    }

    @Override
    public void saveOrUpdateUser(User user) {
        System.out.println("DAO " + user);
        managerFactory.createEntityManager().merge(user);
        //managerFactory.createEntityManager().createNativeQuery("INSERT INTO User (name, surname, age) VALUES ('Imya', 'Famili', 23)").executeUpdate();
    }

    @Override
    public User getUser(int id) {
        return managerFactory.createEntityManager().find(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        managerFactory.createEntityManager().createQuery("DELETE FROM User WHERE id = :idImp")
                .setParameter("idImp", id)
                .executeUpdate();
    }
}
