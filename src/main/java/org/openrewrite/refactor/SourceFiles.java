package org.openrewrite.refactor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.util.Collections.emptyList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.openrewrite.SourceFile;
import org.openrewrite.java.JavaParser;

public class SourceFiles {
    public static List<SourceFile> fromDirectory(String sourceDirectory) throws IOException {
        JavaParser javaParser = JavaParser.fromJavaVersion().build();
        List<Path> javaSources = new ArrayList<>(listJavaSources(sourceDirectory));
        return new ArrayList<>(javaParser.parse(javaSources, Paths.get(sourceDirectory)));
    }

    private static List<Path> listJavaSources(String sourceDirectory) throws IOException {
        File sourceDirectoryFile = new File(sourceDirectory);
        if (!sourceDirectoryFile.exists()) {
            return emptyList();
        }
        Path sourceRoot = sourceDirectoryFile.toPath();
            return Files.walk(sourceRoot)
                .filter(f -> !Files.isDirectory(f) && f.toFile().getName().endsWith(".java"))
                .collect(toList());
    }
}
