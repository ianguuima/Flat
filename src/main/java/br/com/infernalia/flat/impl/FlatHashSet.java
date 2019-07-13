package br.com.infernalia.flat.impl;

import br.com.infernalia.flat.Flat;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FlatHashSet<T> extends HashSet<T> implements Flat<T> {

   public FlatHashSet() {
      super();
   }

   public FlatHashSet(Collection<? extends T> elements) {
      super(elements);
   }

   public Optional<T> find(Predicate<T> predicate) {

      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()) {

         T next = iterator.next();

         if (predicate.test(next)) {
            return Optional.ofNullable(next);
         }
      }


      return Optional.empty();
   }

   @Override
   public Flat<T> filter(Predicate<T> predicate) {
      Flat<T> copy = new FlatHashSet<>();

      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()) {

         T next = iterator.next();
         if (predicate.test(next)) {
            copy.add(next);
         }
      }

      return copy;
   }

   @Override
   public T get(Predicate<T> predicate) {
      return find(predicate)
              .orElse(null);
   }


   @Override
   public T get(Predicate<T> predicate, T def) {
      return find(predicate)
              .orElse(def);
   }

   public Flat<T> takeFirst(int size) {

      Flat<T> flat = new FlatArrayList<>();

      int i = 0;

      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()) {

         if (i >= size) break;

         T next = iterator.next();

         flat.add(next);

         i++;
      }

      return flat;
   }

   @Override
   public <R> Flat<R> map(Function<T, R> function) {
      Flat<R> newFlat = new FlatHashSet<>();

      for (T t : this) {
         newFlat.add(function.apply(t));
      }

      return newFlat;
   }


}
