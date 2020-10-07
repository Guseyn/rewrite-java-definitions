package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.ImplementInterface;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.refactor.RefactorProcessor;

public class AddSerializable extends JavaRefactorVisitor {
    public J visitClassDecl(J.ClassDecl classDecl) {
        andThen(new ImplementInterface.Scoped(
            classDecl,
            "java.io.Serializable"
        ));
        return super.visitClassDecl(classDecl);
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new AddSerializable(), "H.java");
    }
}
