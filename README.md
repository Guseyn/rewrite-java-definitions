# Rewrite Java Definitions

This project contains set of visitors from the [docs](https://docs.openrewrite.org/java/refactoring-java-source-code) of [Rewrite](https://github.com/openrewrite/rewrite) project. The main purpose of this project is to show how java definitions can be used in the code. Also this project is real life example of what you can see in the docs of Rewrite project.

## Project structure

```
├── src
│ └── main
│  └── java
│   └── org
│    └── openrewrite
│     ├── after
│     ├── before
│     ├── definitions
│     ├── examplellib
│     ├── refactor
│     └── visitors
```

1) Folder `definitions` contains Java Definitions (visitors).
2) Folder `visitor` contains additional visitors.
3) Folder `refactor` contains `RefactorProcessor` that works in the following way:

    ```java
    // Example
    List<RefactorVisitor<?>> visitors = new ArrayList<>(){{
       add(visitor1);
       add(visitor2);
       add(visitor3);
    }};
    RefactorProcessor.run(visitors, "A.java");
    ``` 
    `RefactorProcessor.run(visitors, "A.java")` takes file `A.java` from folder `before`, applies visitors which is in `ArrayList`(as first argument) and then puts updated `A.java` into `after` folder.
 4)  Folder `before` contains original java files.
 5)  Folder `after` contains java files that have been processed by visitors from `definitions` folder.
 
 # How to run definitions
 Each of classes in `definitions` folder is executable, which applies visitors for one specified java file from `before` folder and puts updated version of it into `after` folder.
