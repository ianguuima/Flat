package br.com.infernalia.flat;

import br.com.infernalia.flat.impl.FlatArrayList;
import br.com.infernalia.flat.impl.FlatHashSet;

import static java.util.Arrays.asList;

public class Flats {

   public static <T> Flat<T> emptyList() {
      return new FlatArrayList<>();
   }

   public static <T> Flat<T> emptySet() {
      return new FlatHashSet<>();
   }

   @SafeVarargs
   public static <T> Flat<T> listOf(T... array) {
      return new FlatArrayList<>(asList(array));
   }

   @SafeVarargs
   public static <T> Flat<T> setOf(T... array) {
      return new FlatHashSet<>(asList(array));
   }

   public static Flat<Integer> intFlat(int min , int max){

      Flat<Integer> integers = new FlatHashSet<>();

      for (int i = min; i < max; i++) {
         integers.add(i);
      }

      return integers;
   }

}
