package br.ufms.bancas.service;

import br.ufms.bancas.dao.UserDao;
import br.ufms.bancas.model.User;
import com.google.inject.Inject;

import java.util.Optional;

public class LoginService {
    private final UserDao userDao;

    @Inject
    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(String username, String password) {
        // TODO: validate in user table, and check hash

        Optional<?> user = userDao.findByUser(username);
        if (user.isPresent()) {
            User userObject = (User) user.get();
            return userObject.getPassword().equals(password);
        }

        return false;
    }
}
