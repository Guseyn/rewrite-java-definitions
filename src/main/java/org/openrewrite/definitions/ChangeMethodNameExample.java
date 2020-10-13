package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.ChangeMethodName;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class ChangeMethodNameExample {
    public static void main(String... args) throws IOException {
        ChangeMethodName cmn = new ChangeMethodName();
        cmn.setMethod("org.openrewrite.classes.ClassWithMethods foo()");
        cmn.setName("bar");
        ChangeMethodName cmnStatic = new ChangeMethodName();
        cmnStatic.setMethod("org.openrewrite.classes.ClassWithMethods fooStatic()");
        cmnStatic.setName("barStatic");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        List<RefactorVisitor<?>> visitors = new ArrayList<>(){{
            // add(cmn);
            add(cmnStatic);
            add(cpn);
        }};
        RefactorProcessor.run(visitors, "E.java");
    };
}
