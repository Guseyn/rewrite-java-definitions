package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.UseStaticImport;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class UseStaticImportExample {
    public static void main(String... args) throws IOException {
        UseStaticImport si = new UseStaticImport();
        si.setMethod("org.junit.jupiter.api.Assertions assert*(..)");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(si);
            add(cpn);
        }}, "L.java");
    }
}
