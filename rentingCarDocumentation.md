# rentingCar Documentation

## UML Data Model

### CLASS Car

```java
package org.example;

public class Car {
    private String id;
    private String brand;
    private String model;
    private String plate;
    private int year;
    private double price;

    // constructor, geters, setters, methods and toString
}

```

### CLASS Client

```java

public class Client {
    
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private boolean premium;

    // constructor, geters, setters, methods and toString

}
```

#### CLASS Booking

todo


## Goal
> Rent a car by CLI with client, car, init and ending date, price


## Tech Stack

- IDE: IntelliJ IDEA 2025.1.3 (Community Edition
- Java 21
- JUniit 3.8.1
- Maven Project: **`maven-archetype-quickstart` archetype**


## POM.XML
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.example</groupId>
  <artifactId>rentingCarTest</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>
    
  <name>rentingCarTest</name>
  <url>http://maven.apache.org</url>
    
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>

```