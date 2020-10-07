package org.openrewrite.refactor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import org.openrewrite.Change;
import org.openrewrite.Refactor;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.SourceFile;
import org.openrewrite.java.JavaRefactorVisitor;

public class RefactorProcessor {
    public static void run(JavaRefactorVisitor javaRefactorVisitor, String javaExampleFileName) throws IOException {
        Iterable<RefactorVisitor<?>> visitors = new ArrayList<>(){{
            add(javaRefactorVisitor);
        }};
        run(visitors, javaExampleFileName);
    }

    public static void run(Iterable<RefactorVisitor<?>> visitors, String javaExampleFileName) throws IOException {
        Iterable<SourceFile> sources = SourceFiles.fromDirectory("src/main/java/org/openrewrite/before/".concat(javaExampleFileName));
        Refactor refactor = new Refactor().visit(visitors);
        Collection<Change> changes = refactor.fix(sources);
        for (Change change : changes) {
            Path file = Paths.get("src/main/java/org/openrewrite/after/").resolve(change.getOriginal().getSourcePath().concat(javaExampleFileName));
            try (BufferedWriter sourceFileWriter = Files.newBufferedWriter(file)) {
                sourceFileWriter.write(change.getFixed().print().replace("package org.openrewrite.before;", "package org.openrewrite.after;"));
            }
        }
    }
}
