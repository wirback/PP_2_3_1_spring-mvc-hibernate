package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class    UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User getUserById(Long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select user from User user where user.id = :id", User.class);

        return query.setParameter("id", id)
                .getResultList()
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }
}
