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
import org.openrewrite.definitions.AddSetField;

public class RefactorProcessor {
    public static void main(String ...args) throws IOException {
        Iterable<SourceFile> sources = SourceFiles.fromDirectory("src/sample-project");

        Iterable<RefactorVisitor<?>> visitors = new ArrayList<>(){{
            add(new AddSetField());
        }};
        Refactor refactor = new Refactor().visit(visitors);
        Collection<Change> changes = refactor.fix(sources);
        for (Change change : changes) {
            Path file = Paths.get("src/sample-project/after").resolve(change.getOriginal().getSourcePath());
            try (BufferedWriter sourceFileWriter = Files.newBufferedWriter(file)) {
                sourceFileWriter.write(change.getFixed().print());
            }
        }
    }
}
