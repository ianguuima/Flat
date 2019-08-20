package br.com.infernalia.flat.impl;

import br.com.infernalia.flat.Flat;
import br.com.infernalia.flat.FlatMap;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;

public class FlatHashMap<K, V> extends HashMap<K, V> implements FlatMap<K, V> {

   @Override
   public Optional<K> findKey(V value) {
      return keyFlat().find(key -> get(key).equals(value));
   }

   @Override
   public Optional<V> findValue(K key) {
      return valueFlat().find(value -> get(key).equals(value));
   }

   @Override
   public Flat<K> keyFlat() {
      return new FlatHashSet<>(keySet());
   }

   @Override
   public Flat<V> valueFlat() {
      return new FlatHashSet<>(values());
   }

   @Override
   public FlatMap<K, V> filter(BiPredicate<K, V> predicate) {

      Set<Entry<K, V>> entries = this.entrySet();

      FlatMap<K, V> flatMap = new FlatHashMap<>();

      for (Entry<K, V> entry : entries) {

         if (predicate.test(entry.getKey(), entry.getValue())) {
            flatMap.put(entry.getKey(), entry.getValue());
         }
      }

      return flatMap;
   }
}
