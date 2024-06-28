package br.ufms.bancas.utils;

import java.util.Optional;
import java.util.stream.Stream;

public interface Dao<T> {
    public void save(T object);

    public void update(T object);

    public void delete(T object);
    public void deleteById(Object id);

    public Optional<T> findOne(Object id);

    public Stream<T> list();
}

