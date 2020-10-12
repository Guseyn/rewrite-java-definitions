package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.ChangeMethodName;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.TreeBuilder;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class ChangeMethodNameExample {
    public static void main(String... args) throws IOException {
        ChangeMethodName cmn = new ChangeMethodName();
        cmn.setMethod("org.openrewrite.before.E foo()");
        cmn.setName("bar");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(cmn);
            add(cpn);
        }}, "E.java");
    }
}
