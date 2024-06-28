package br.ufms.bancas.dao.memory;

import br.ufms.bancas.dao.PublisherDao;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.service.SaveService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class PublisherDaoMemory implements PublisherDao {
    private HashMap<Long, Publisher> publisherMap;

    private static final String FILE = "publishers.bin";
    private final SaveService saveService;

    @Inject
    @SuppressWarnings("unchecked")
    public PublisherDaoMemory(SaveService saveService) {
        this.saveService = saveService;

        try {
            this.publisherMap = (HashMap<Long, Publisher>) this.saveService.load(HashMap.class, FILE);
        } catch (FileNotFoundException ignored) {
            this.publisherMap = new HashMap<>();
        }
    }

    @Override
    public Stream<Publisher> findByName(String name) {
        return publisherMap.values().stream().filter(p -> p.getName().contains(name));
    }

    @Override
    public void save(Publisher object) {
        publisherMap.put(object.getId(), object);
        try {
            this.saveService.save(publisherMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void update(Publisher object) {
        publisherMap.replace(object.getId(), object);
        try {
            this.saveService.save(publisherMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void delete(Publisher object) {
        publisherMap.remove(object.getId());
        try {
            this.saveService.save(publisherMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void deleteById(Object id) {
        publisherMap.remove((Long) id);
        try {
            this.saveService.save(publisherMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public Optional<Publisher> findOne(Object id) {
        return publisherMap.values().stream().filter(obj -> obj.getId().equals(id)).findFirst();
    }

    @Override
    public Stream<Publisher> list() {
        return publisherMap.values().stream();
    }
}
