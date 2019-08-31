package br.com.infernalia.flat.impl.immutable;

import br.com.infernalia.flat.impl.FlatArrayList;

import java.util.Optional;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ImmutableFlatArrayList<T> extends ArrayList<T> implements ImmutableFlat<T> {


   public ImmutableFlatArrayList(int initialCapacity) {
      super(initialCapacity);
   }

   public ImmutableFlatArrayList() {
      super();
   }

   public ImmutableFlatArrayList(Collection<? extends T> c) {
      super(c);
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

   public ImmutableFlat<T> reversed() {
      this.sort(Collections.reverseOrder());
      return this;
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


   @Override
   public ImmutableFlat<T> takeFirst(int size) {

      ImmutableFlat<T> flat = new ImmutableFlatArrayList<>();

      for (int n = 0; n < size; n++) {

         T t = this.get(n);

         if (t != null) {
            flat.add(t);
         }
      }

      return flat;
   }

   public ImmutableFlat<T> takeLast(int size) {
      ImmutableFlat<T> flat = new ImmutableFlatArrayList<>();

      for (int n = size; n > 0; n--) {
         T t = this.get(n);

         if (t != null) {
            flat.add(t);
         }
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
