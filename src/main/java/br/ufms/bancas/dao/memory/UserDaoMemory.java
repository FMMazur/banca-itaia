package br.ufms.bancas.dao.memory;

import br.ufms.bancas.dao.UserDao;
import br.ufms.bancas.model.User;
import br.ufms.bancas.service.SaveService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class UserDaoMemory implements UserDao {
    private static final String FILE = "users.bin";
    private final SaveService saveService;
    private HashMap<Long, User> userMap = new HashMap<>();

    @Inject
    @SuppressWarnings("unchecked")
    public UserDaoMemory(SaveService saveService) {
        this.saveService = saveService;

        try {
            HashMap<Long, User> map = (HashMap<Long, User>) this.saveService.load(HashMap.class, FILE);
            if (map != null) this.userMap = map;
        } catch (FileNotFoundException ignored) {
            User user = new User("admin");
            user.setId(0L);
            user.setPassword("admin");
            this.save(user);
        }
    }

    @Override
    public void save(User object) {
        userMap.put(object.getId(), object);
        try {
            this.saveService.save(userMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void update(User object) {
        userMap.replace(object.getId(), object);
        try {
            this.saveService.save(userMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void delete(User object) {
        userMap.remove(object.getId());
        try {
            this.saveService.save(userMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void deleteById(Object id) {
        userMap.remove((Long) id);
        try {
            this.saveService.save(userMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public Optional<User> findOne(Object id) {
        return userMap.values().stream().filter(obj -> obj.getId().equals(id)).findFirst();
    }

    @Override
    public Stream<User> list() {
        return userMap.values().stream();
    }

    @Override
    public Optional<User> findByUser(String username) {
        return userMap.values().stream().filter(obj -> obj.getUsername().equals(username)).findFirst();
    }
}
