package org.openrewrite.definitions;

import java.io.IOException;
import static java.util.Collections.emptyList;
import org.openrewrite.java.AddField;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.refactor.RefactorProcessor;

public class AddLogger extends JavaRefactorVisitor {
    public J visitClassDecl(J.ClassDecl clazz) {
        if(needsLogger(clazz) && clazz
            .findFields("org.slf4j.Logger")
            .isEmpty()) {

            andThen(new AddField.Scoped(
                clazz,
                emptyList(), // modifiers
                "org.slf4j.Logger",
                "logger", // field name
                "LoggerFactory.getLogger(" + clazz.getSimpleName() + ".class);" // Assignment expression
            ));
            // since this is used in the initializer above
            // maybeAddImport("org.slf4j.LoggerFactory");
            addImport("org.slf4j.LoggerFactory");
        }
        return super.visitClassDecl(clazz);
    }

    private boolean needsLogger(J.ClassDecl clazz) {
        return true;
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new AddLogger(), "B.java");
    }
}
