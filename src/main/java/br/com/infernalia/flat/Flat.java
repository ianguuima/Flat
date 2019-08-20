package br.com.infernalia.flat;

import br.com.infernalia.flat.impl.FlatArrayList;
import br.com.infernalia.flat.impl.FlatHashSet;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Flat<T> extends Collection<T> {

   Optional<T> find(Predicate<T> predicate);

   T get(Predicate<T> predicate);

   T get(Predicate<T> predicate, T def);

   default T getEquals(Object object) {

      for (T t : this) {
         if (t.equals(object)) {
            return t;
         }
      }

      return null;
   }

   default T getEquals(Object object, T def) {
      T equals = this.getEquals(object);
      return equals != null ? equals : def;
   }


   <R> Flat<R> map(Function<T, R> function);

   Flat<T> filter(Predicate<T> predicate);

   Flat<T> takeFirst(int size);


   default String join(String separator) {
      return String.join(separator, map(Object::toString));
   }

   default String join(Function<T, String> function, String separator) {
      return String.join(separator, map(function));
   }

   default String join(Function<T, String> function) {
      return join(function, " ");
   }

   default String join() {
      return join(" ");
   }


   default boolean matches(Predicate<T> predicate) {
      for (T t : this) {

         if (predicate.test(t)) {
            return true;
         }
      }

      return false;
   }

   default <R extends Collection<T>> R collect(Supplier<R> function) {
      R r = function.get();
      r.addAll(this);

      return r;
   }

   static <T> FlatArrayList<T> emptyList() {
      return new FlatArrayList<>();
   }

   static <T> FlatHashSet<T> emptySet() {
      return new FlatHashSet<>();
   }





}
