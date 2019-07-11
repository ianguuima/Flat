package br.com.infernalia.flat;

import br.com.infernalia.flat.impl.FlatArrayList;
import br.com.infernalia.flat.impl.FlatHashSet;

import java.util.Arrays;

import static java.util.Arrays.*;

public class Flats {

   public static <T> Flat<T> mutableListOf(T... array){
      return new FlatArrayList<>(asList(array));
   }

   public static <T> Flat<T> mutableSetOf(T... array){
      return new FlatHashSet<>(asList(array));
   }


}
