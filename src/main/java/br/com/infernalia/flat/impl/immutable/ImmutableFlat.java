package br.com.infernalia.flat.impl.immutable;

import br.com.infernalia.flat.Flat;

import java.util.Collection;
import java.util.function.Predicate;


public interface ImmutableFlat<T> extends Flat<T> {

   public static <E> ImmutableFlat<E> of(Collection<E> collection) {
      return new ImmutableFlatHashSet<E>(collection);
   }

   @Override
   default boolean add(T t) throws UnsupportedOperationException {
      throw new UnsupportedOperationException("You cannot change a immutable flat.");
   }

   @Override
   default boolean addAll(Collection<? extends T> c) throws UnsupportedOperationException {
      throw new UnsupportedOperationException("You cannot change a immutable flat.");
   }

   @Override
   default boolean remove(Object o) throws UnsupportedOperationException {
      throw new UnsupportedOperationException("You cannot change a immutable flat.");

   }

   @Override
   default boolean removeIf(Predicate<? super T> filter) throws UnsupportedOperationException {
      throw new UnsupportedOperationException("You cannot change a immutable flat.");
   }
}
