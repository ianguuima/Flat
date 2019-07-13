package br.com.infernalia.flat;

import junit.framework.TestCase;

public class FlatTest extends TestCase {


   @Override
   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testMultiFilter() {

      Flat<Integer> integers = Flats.intFlat(1, 20_000)
              .filter(it -> it % 10 == 0)
              .takeFirst(20);

      System.out.println("Valores: " + integers.join(", "));

      int found = integers.getEquals(130);

      if(found != 0){
         System.out.println("Valor achado " + found);
      }
   }

}
