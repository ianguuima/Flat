package br.com.infernalia.flat;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

public interface FlatMap<K, V> extends Map<K, V> {

   Optional<K> findKey(V value);

   Optional<V> findValue(K key);

   Flat<K> keyFlat();

   Flat<V> valueFlat();

   FlatMap<K , V> filter(BiPredicate<K , V> predicate);


}
