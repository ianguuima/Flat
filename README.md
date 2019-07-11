# Flat
Bibilioteca para facilitar o codigo com as coleções do java.


## Funcionalidade
A Bibilioteca visa que o desenvolvedor escreva menos codigo , e tenha mais produtividade
na hora de usar collections do java.

### Criação
```java
//Java 8
List<String> stringList = Arrays.asList("Red", "Green", "Blue");

// Flat
Flat<String> stringFlat = Flats.mutableListOf("Red", "Green", "Blue");
```

### Filtrando Elementos

```java
//Java 8
List<String> lowCaseList = stringList.stream()
              .map(String::toLowerCase)
              .collect(Collectors.toList());

// Flat
Flat<String> lowCaseFlat = stringFlat.map(String::toLowerCase);
```

### Aplicando Consumers

```java
// Java 8
Collection<String> strings = Arrays.asList("Red", "Green", "Blue");
strings.forEach(System.out::println); // void

// Flat
Flat<String> stringsFlat = Flats.mutableListOf("Red" , "Green" , "Blue")
              .apply(System.out::println)
              .map(String::toUpperCase)
              .apply(System.out::println);
```

### Achando e Pegando valores

```java
//Java 8
Collection<String> collection = Arrays.asList("Red", "Green", "Blue");

// optional
Optional<String> optionalString = collection.stream()
              .filter(string -> string.equalsIgnoreCase("Red"))
              .findFirst();

// Flat

Flat<String> flat = Flats.mutableListOf("Red", "Green", "Blue");

// optional
Optional<String> optionalString = flat.find(string -> string.equalsIgnoreCase("Red"));

// nullable
String redString = flat.get(string -> string.equalsIgnoreCase("Red"));

// null safely
String redString = flat.get(string -> string.equalsIgnoreCase("Red") , "Red");
```
