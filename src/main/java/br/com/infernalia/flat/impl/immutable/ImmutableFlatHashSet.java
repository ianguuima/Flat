package br.com.infernalia.flat.impl.immutable;

import br.com.infernalia.flat.Flat;
import br.com.infernalia.flat.impl.FlatArrayList;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ImmutableFlatHashSet<T> extends HashSet<T> implements ImmutableFlat<T> {

   public ImmutableFlatHashSet() {
      super();
   }

   public ImmutableFlatHashSet(Collection<? extends T> c) {
      super(c);
   }

   public ImmutableFlatHashSet(int initialCapacity, float loadFactor) {
      super(initialCapacity, loadFactor);
   }

   public ImmutableFlatHashSet(int initialCapacity) {
      super(initialCapacity);
   }

   @Override
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
   public ImmutableFlat<T> filter(Predicate<T> predicate) {
      ImmutableFlat<T> copy = new ImmutableFlatArrayList<>();

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

      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()) {
         T next = iterator.next();
         if (predicate.test(next)) {
            return next;
         }
      }

      return null;
   }

   @Override
   public T get(Predicate<T> predicate, T def) {
      T t = this.get(predicate);

      return t == null ? def : t;
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
   public <R> ImmutableFlat<R> map(Function<T, R> function) {
      ImmutableFlat<R> newFlat = new ImmutableFlatArrayList<>();

      for (T t : this) {
         newFlat.add(function.apply(t));
      }

      return newFlat;
   }
}
