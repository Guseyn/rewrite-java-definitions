package org.openrewrite.definitions;

import org.openrewrite.java.JavaRefactorVisitor;
import org.openrewrite.java.tree.J;

public class ImportSet extends JavaRefactorVisitor {
    public J visitClassDecl(J.ClassDecl clazz) {
        maybeAddImport("java.util.Set");
        return super.visitClassDecl(clazz);
    }
}
