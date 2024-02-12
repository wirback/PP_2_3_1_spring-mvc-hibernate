package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository
//@Transactional
@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public void setUserById(Integer id) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
//        EntityTransaction et = entityManager.getTransaction();
        return entityManager.createQuery("select user from User user", User.class).getResultList();
//        List<User> userList = entityManager.createQuery("from User").getResultList();
//        Session session = sessionFactory.getCurrentSession();

//        return session.createQuery("select user from User user", User.class).getResultList();
    }
}
