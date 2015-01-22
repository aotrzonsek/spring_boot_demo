package demo.repository;

import demo.jpa.User;
import demo.repository.UserRepositoryWithEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepositoryWithEntityManager {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserInEntityManager(long id) {
        return entityManager.find(User.class, id);
    }
}
