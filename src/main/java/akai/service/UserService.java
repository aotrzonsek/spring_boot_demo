package akai.service;

import akai.jpa.User;
import akai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public void deleteUserById(long userId) {
        User user = userRepository.findOne(userId);
        validateUserBeforeDelete(user);
        user.setActive(false);
    }

    private void validateUserBeforeDelete(User user) {
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.isActive()) {
            throw new RuntimeException("User is not active!");
        }
    }
}
