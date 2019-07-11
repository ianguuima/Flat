# Flat
Bibilioteca para facilitar o codigo com as coleções do java.

## Funcionalidade
A Bibilioteca visa que o desenvolvedor escreva menos codigo , e tenha mais produtividade
na hora de usar collections do java.

# Instalando

Por enquanto você pode usar o JitPack para obter a dependencia maven

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
   <groupId>com.github.infernalia</groupId>
   <artifactId>Flat</artifactId>
   <version>master-SNAPSHOT</version>
</dependency>
```

### Criação
```java
//Java 8
List<String> stringList = Arrays.asList("Red", "Green", "Blue");

Set<String> stringSet = new HashSet(Arrays.asList("Red" , "Green" , "Blue");

// Flat

// list
Flat<String> stringFlatList = Flats.listOf("Red", "Green", "Blue");
// or 
Flat<String> stringFlatList = Flats.emptyList();

// set
Flat<String> stringFlatSet = Flats.setOf("Red", "Green", "Blue");
// or
Flat<String> stringFlatSet = Flats.emptySet();
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


