package br.ufms.bancas.service;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@Singleton
public class SaveService {
    private final Kryo kryo;

    @Inject
    public SaveService(Kryo kryo) {
        this.kryo = kryo;
    }

    public void save(Object object, String filePath) throws FileNotFoundException {
        Output output = new Output(new FileOutputStream("data/" + filePath));
        this.kryo.writeObject(output, object);
        output.close();
    }

    public Object load(Class<?> clazz, String filePath) throws FileNotFoundException {
        try (Input input = new Input(new FileInputStream("data/" + filePath))) {
            Object loaded = this.kryo.readObjectOrNull(input, clazz);
            input.close();

            return loaded;
        }
    }
}
