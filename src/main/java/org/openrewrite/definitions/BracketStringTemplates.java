package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.ChangeLiteral;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.JavaType;
import org.openrewrite.refactor.RefactorProcessor;

public class BracketStringTemplates extends JavaRefactorVisitor {
    public J visitLiteral(J.Literal lit) {
        if(lit.getType().equals(JavaType.Primitive.String) &&
            lit.getValue().toString().contains("%s")) {

            andThen(new ChangeLiteral.Scoped(
                lit,
                s -> s.toString().replace("%s", "{}")
            ));
        }
        return super.visitLiteral(lit);
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new BracketStringTemplates(), "D.java");
    }
}
