package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.AddAnnotation;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.refactor.RefactorProcessor;

public class AddAnnotationExample extends JavaRefactorVisitor {
    public J visitMethod(J.MethodDecl method) {
        if(isPublicApi(method) && method
            .findAnnotations("@org.junit.jupiter.api.AfterAll")
            .isEmpty() && method.getName().toString().contains("after")) {

            andThen(new AddAnnotation.Scoped(
                method,
                "org.junit.jupiter.api.AfterAll"
            ));
        }
        if(isPublicApi(method) && method
            .findAnnotations("@org.junit.jupiter.api.BeforeAll")
            .isEmpty() && method.getName().toString().contains("before")) {

            andThen(new AddAnnotation.Scoped(
                method,
                "org.junit.jupiter.api.BeforeAll"
            ));
        }
        return super.visitMethod(method);
    }

    private boolean isPublicApi(J.MethodDecl method) {
        return true;
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new AddAnnotationExample(), "M.java");
    }
}
