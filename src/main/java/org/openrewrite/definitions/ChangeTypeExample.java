package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.ChangeType;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class ChangeTypeExample {
    public static void main(String... args) throws IOException {
        ChangeType ct = new ChangeType();
        ct.setType("java.util.List");
        ct.setTargetType("java.util.Collection");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(ct);
            add(cpn);
        }}, "F.java");
    }
}
