package br.ufms.bancas.dao;

import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.utils.Dao;

import java.util.stream.Stream;

public interface PublisherDao extends Dao<Publisher> {
    public Stream<Publisher> findByName(String name);
}
