package br.ufms.bancas.dao.memory;

import br.ufms.bancas.dao.DbImageDao;
import br.ufms.bancas.model.DbImage;
import br.ufms.bancas.service.SaveService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class DbImageDaoMemory implements DbImageDao {
    private HashMap<Long, DbImage> imageMap;

    private static final String FILE = "dbimage.bin";
    private final SaveService saveService;

    @Inject
    @SuppressWarnings("unchecked")
    public DbImageDaoMemory(SaveService saveService) {
        this.saveService = saveService;

        try {
            this.imageMap = (HashMap<Long, DbImage>) this.saveService.load(HashMap.class, FILE);
        } catch (FileNotFoundException ignored) {
            this.imageMap = new HashMap<>();
        }
    }

    @Override
    public void save(DbImage object) {
        imageMap.put(object.getId(), object);
        try {
            this.saveService.save(imageMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void update(DbImage object) {
        imageMap.replace(object.getId(), object);
        try {
            this.saveService.save(imageMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void delete(DbImage object) {
        imageMap.remove(object.getId());
        try {
            this.saveService.save(imageMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void deleteById(Object id) {
        imageMap.remove((Long) id);

        try {
            this.saveService.save(imageMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public Optional<DbImage> findOne(Object id) {
        return imageMap.values().stream().filter(obj -> obj.getId().equals(id)).findFirst();
    }

    @Override
    public Stream<DbImage> list() {
        return imageMap.values().stream();
    }
}
