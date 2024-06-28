package br.ufms.bancas.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.HashMap;
import java.util.Map;

public class HashMapSerializer extends Serializer<HashMap> {
    @Override
    public void write(Kryo kryo, Output output, HashMap map) {
        output.writeInt(map.size());
        for (Object key : map.keySet()) {
            kryo.writeClassAndObject(output, key);
            kryo.writeClassAndObject(output, map.get(key));
        }
    }

    @Override
    public HashMap read(Kryo kryo, Input input, Class<? extends HashMap> type) {
        int size = input.readInt();
        HashMap map = new HashMap(size);
        for (int i = 0; i < size; i++) {
            Object key = kryo.readClassAndObject(input);
            Object value = kryo.readClassAndObject(input);
            map.put(key, value);
        }
        return map;
    }
}
