package br.com.infernalia.flat.impl;

import br.com.infernalia.flat.Flat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FlatArrayList<T> extends ArrayList<T> implements Flat<T> {

   public FlatArrayList() {
      super();
   }

   public FlatArrayList(Collection<? extends T> elements) {
      super(elements);
   }

   @Override
   public Optional<T> find(Predicate<T> predicate) {

      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()){

         T next = iterator.next();

         if(predicate.test(next)){
            return Optional.ofNullable(next);
         }
      }


      return Optional.empty();
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

   @Override
   public <R> Flat<R> map(Function<T, R> function) {
      Flat<R> newFlat = new FlatArrayList<>();

      for (T t : this) {
         newFlat.add(function.apply(t));
      }

      return newFlat;
   }


}
