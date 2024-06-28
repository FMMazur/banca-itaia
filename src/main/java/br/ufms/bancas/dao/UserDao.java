package br.ufms.bancas.dao;

import br.ufms.bancas.model.User;
import br.ufms.bancas.utils.Dao;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByUser(String username);
}
