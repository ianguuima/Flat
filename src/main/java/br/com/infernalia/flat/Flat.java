package br.com.infernalia.flat;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Flat<T> extends Collection<T> {

   Optional<T> find(Predicate<T> predicate);

   T get(Predicate<T> predicate);

   T get(Predicate<T> predicate , T def);

   Flat<T> apply(Consumer<T> consumer);

   <R> Flat<R> map(Function<T , R> function);

   <R extends Collection<T>> R collect(Supplier<R> function);
}
