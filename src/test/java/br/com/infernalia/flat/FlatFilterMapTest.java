package br.com.infernalia.flat;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FlatFilterMapTest extends TestCase {

   private List<Integer> integerList;
   private Flat<Integer> integerFlat;

   @Override
   protected void setUp() throws Exception {
      super.setUp();

      integerList = new ArrayList<>();

      for(int i = 1; i < 200; i ++){
         integerList.add(i);
      }

      integerFlat = Flats.intFlat(1 , 200);
   }


   public void testFilter() throws Exception{
      assertFalse(normalTimingTest() <= flatTimingTest());
   }

   private long normalTimingTest() {
      long start = System.currentTimeMillis();

      List<String> list = integerList.stream()
              .filter(it -> it % 10 == 0)
              .sorted(Collections.reverseOrder())
              .map(String::valueOf)
              .collect(Collectors.toList());

      list.forEach(str -> System.out.print(str + " "));

      long finalTime = System.currentTimeMillis() - start;
      System.out.println("Time wasted with java 8 collector: " + finalTime + "ms");

      return finalTime;
   }

   private long flatTimingTest() {

      long start = System.currentTimeMillis();

      Flat<String> flat = integerFlat.filter(it -> it % 10 == 0)
              .reversed()
              .map(String::valueOf);

      flat.forEach(str -> System.out.print(str + " "));

      long finalTime = System.currentTimeMillis() - start;
      System.out.println("Time wasted with flat: " + finalTime + "ms");

      return finalTime;
   }


}
