# Wallpaper Calculator

Calculates overall wallpaper demand and provides various reports on input data

## Compiling / Building

**REQUIRES JAVA 11 OR HIGHER VERSION**

Use maven command to (re-)build the artifact:

```shell
mvn clean verify package
```

## Running

Maven build an executable jar, so it can be executed directly with java command, for example

```shell
java -jar target/wallpaper-calculator-1.0-SNAPSHOT.jar sample-input.txt
```

Make sure you pass path to the input file as program argument (path can be absolute or relative to the current folder)

## Integration Tests

In addition to unit test suite, the application contains simple end-to-end integration test class, which
brings the test coverage to over 90%

Integration test class
```
gscf.wallpaper.MainIT
```
