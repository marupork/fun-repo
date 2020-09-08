# Minimal Project

This is sample of a minimal Java 11 project using Maven.

## Create

```cmd
mvn archetype:generate -DgroupId=com.sample.demo -DartifactId=rename_me -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

## Update

- Rename artifactId and name on pom.xml. Rename the folder as well.

```xml
  <groupId>com.sample.demo</groupId>
  <artifactId>rename_me</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>rename_me</name>
```

- Clean install the updated project

```cmd
$ mvn clean install
[INFO] BUILD SUCCESS
```

- Run the basic part

```cmd
$ java -cp target/rename_me-1.0-SNAPSHOT.jar com.sample.demo.App
Hello World!
```

### Resource

- [Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
