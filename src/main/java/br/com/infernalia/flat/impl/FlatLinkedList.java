package br.com.infernalia.flat.impl;

import br.com.infernalia.flat.Flat;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FlatLinkedList<T> extends LinkedList<T> implements Flat<T> {

   public FlatLinkedList() {
      super();
   }

   public FlatLinkedList(Collection<? extends T> elements) {
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
   public Flat<T> apply(Consumer<T> consumer) {
      Iterator<T> iterator = this.iterator();

      while (iterator.hasNext()){
         consumer.accept(iterator.next());
      }

      return this;
   }

   @Override
   public <R> Flat<R> map(Function<T, R> function) {
      Flat<R> newFlat = new FlatArrayList<>();

      for (T t : this) {
         newFlat.add(function.apply(t));
      }

      return newFlat;
   }

   @Override
   public <R extends Collection<T>> R collect(Supplier<R> function) {
      R r = function.get();
      r.addAll(this);

      return r;
   }
}
