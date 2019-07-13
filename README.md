
[![](https://jitpack.io/v/infernalia/Flat.svg)](https://jitpack.io/#infernalia/Flat)

# Flat
Bibilioteca para facilitar o codigo com as coleções do java.

## Funcionalidade
A Bibilioteca visa que o desenvolvedor escreva menos codigo , e tenha mais produtividade
na hora de usar collections do java.

# Instalando

Por enquanto você pode usar o JitPack para obter a dependencia maven ou gradle

### Maven 
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
    <version>c826a996</version>
</dependency>
```

### Gradle

```gradle
allprojects {
     repositories {
     ...
     maven { url 'https://jitpack.io' }
   }
}

dependencies {
    implementation 'com.github.infernalia:Flat:c826a996'
}

```
