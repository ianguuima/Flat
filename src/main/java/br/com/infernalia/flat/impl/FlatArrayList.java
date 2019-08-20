package br.com.infernalia.flat.impl;

import br.com.infernalia.flat.Flat;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class FlatArrayList<T> extends ArrayList<T> implements Flat<T>{

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

   public Flat<T> reversed(){
      this.sort(Collections.reverseOrder());
      return this;
   }


   @Override
   public Flat<T> filter(Predicate<T> predicate) {
      Flat<T> copy = new FlatArrayList<>();

      Iterator<T> iterator = this.iterator();

      while(iterator.hasNext()){

         T next = iterator.next();
         if(predicate.test(next)){
            copy.add(next);
         }
      }

      return copy;
   }


   @Override
   public T get(Predicate<T> predicate) {

      Iterator<T> iterator = this.iterator();

      while(iterator.hasNext()){
         T next = iterator.next();
         if(predicate.test(next)){
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
   public Flat<T> takeFirst(int size){

      Flat<T> flat = new FlatArrayList<>();

      for (int n = 0; n < size; n++) {

         T t = this.get(n);

         if(t != null){
            flat.add(t);
         }
      }

      return flat;
   }

   public Flat<T> takeLast(int size) {
      Flat<T> flat = new FlatArrayList<>();

      for(int n = size; n > 0; n--){
         T t = this.get(n);

         if(t != null){
            flat.add(t);
         }
      }

      return flat;
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
