package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.AutoFormat;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.TreeBuilder;
import org.openrewrite.refactor.RefactorProcessor;

public class ComplexMethodTransformation extends JavaRefactorVisitor {
    @Override
    public J.Package visitPackage(J.Package pkg) {
        return pkg.withExpr(TreeBuilder.buildName("org.openrewrite.after").withPrefix(pkg.getPrefix().concat(" ")));
    }

    public J visitMethod(J.MethodDecl method) {
        // do some things to modify the method declaration
        // or body in some significant way and don't worry about formatting...

        // this will fix the indentation of the method declaration to be consistent with its surroundings
        andThen(new AutoFormat(method));

        return super.visitMethod(method);
    }

    public J visitMultiVariable(J.VariableDecls variable) {
        // do some things to modify the method declaration
        // or body in some significant way and don't worry about formatting...

        // this will fix the indentation of the method declaration to be consistent with its surroundings
        andThen(new AutoFormat(variable));

        return super.visitMultiVariable(variable);
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new ComplexMethodTransformation(), "C.java");
    }
}
