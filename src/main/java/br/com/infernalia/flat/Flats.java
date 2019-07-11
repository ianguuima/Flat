package br.com.infernalia.flat;

import br.com.infernalia.flat.impl.FlatArrayList;
import br.com.infernalia.flat.impl.FlatHashSet;
import static java.util.Arrays.*;

public class Flats {

   public static <T> Flat<T> emptyList(){
      return new FlatArrayList<>();
   }

   public static <T> Flat<T> emptySet(){
      return new FlatHashSet<>();
   }

   @SafeVarargs
   public static <T> Flat<T> mutableListOf(T... array){
      return new FlatArrayList<>(asList(array));
   }

   @SafeVarargs
   public static <T> Flat<T> mutableSetOf(T... array){
      return new FlatHashSet<>(asList(array));
   }

}
