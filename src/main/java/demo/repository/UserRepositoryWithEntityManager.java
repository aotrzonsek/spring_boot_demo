package demo.repository;

import demo.jpa.User;

public interface UserRepositoryWithEntityManager {

    User findUserInEntityManager(long id);
}
