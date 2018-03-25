# Bootfaces
Spring boot, Primefaces and rewrite together.

## dependencies 

[openpm webappframework branch spring-boot-mvc](https://github.com/jedlab/openpm/tree/spring-boot-mvc/webappframework)

## How to build

```
mvn clean install -DskipTests=true
```

## How to run

```
http://localhost:8080/login
```

## Tips

If you want to use @Join (rewite annotation) use below line in pom.xml

```
<outputDirectory>src/main/webapp/WEB-INF/classes</outputDirectory>
```

otherwise see [here](https://github.com/omidp/bootfaces/blob/master/src/main/java/com/webportal/app/RewriteConfigurationProvider.java)
