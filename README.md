# Wiki Parser Example
This project contains an example code to extract the first image out of a wikitext article.

## Compile

```
mvn compile
```

## Test

```
mvn test
```

## Package

```
mvn assembly:assembly
```

This will create a self-contained jar in target/wiki-parser-example-1.0-SNAPSHOT-jar-with-dependencies.jar which you can run against a single exported wiki article.

## Running
The wikitext can be fetched using the Special:Export feature of mediawiki. 
http://en.wikipedia.org/wiki/Special:Export/New_York_City

The entire wiki dump can be found on:
http://dumps.wikimedia.org/enwiki/latest/

```
java -jar target/wiki-parser-example-1.0-SNAPSHOT-jar-with-dependencies.jar src/test/resources/wiki-xml/New_York_City.xml
```

