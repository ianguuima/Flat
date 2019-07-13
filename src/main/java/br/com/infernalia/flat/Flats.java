package br.com.infernalia.flat;

import br.com.infernalia.flat.impl.FlatArrayList;
import br.com.infernalia.flat.impl.FlatHashSet;

import static java.util.Arrays.asList;

public class Flats {

   public static <T> FlatArrayList<T> emptyList() {
      return new FlatArrayList<>();
   }

   public static <T> FlatHashSet<T> emptySet() {
      return new FlatHashSet<>();
   }


   @SafeVarargs
   public static <T> FlatArrayList<T> listOf(T... array) {
      return new FlatArrayList<>(asList(array));
   }

   @SafeVarargs
   public static <T> FlatHashSet<T> setOf(T... array) {
      return new FlatHashSet<>(asList(array));
   }



   public static FlatArrayList<Integer> intFlat(int min , int max){

      FlatArrayList<Integer> integers = new FlatArrayList<>();

      for (int i = min; i < max; i++) {
         integers.add(i);
      }


      return integers;
   }

}
