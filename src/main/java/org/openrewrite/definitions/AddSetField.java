package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.AddField;
import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;

import java.util.Collections;
import org.openrewrite.java.tree.TreeBuilder;
import org.openrewrite.refactor.RefactorProcessor;

public class AddSetField extends JavaRefactorVisitor {
    @Override
    public J.Package visitPackage(J.Package pkg) {
        return pkg.withExpr(TreeBuilder.buildName("org.openrewrite.after").withPrefix(pkg.getPrefix().concat(" ")));
    }

    public J visitClassDecl(J.ClassDecl clazz) {

        // maybeAddImport will only add an import if there is usage of the import in the class being refactored
        // This is to avoid adding redundant imports
        andThen(new AddField.Scoped(clazz, Collections.emptyList(), "java.util.Set", "setField", null));
        return super.visitClassDecl(clazz);
    }

    public static void main(String... args) throws IOException {
        RefactorProcessor.run(new AddSetField(), "A.java");
    }
}
