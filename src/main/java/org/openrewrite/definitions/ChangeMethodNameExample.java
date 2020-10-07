package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.ChangeMethodName;
import org.openrewrite.refactor.RefactorProcessor;

public class ChangeMethodNameExample {
    public static void main(String... args) throws IOException {
        ChangeMethodName cmn = new ChangeMethodName();
        cmn.setMethod("org.openrewrite.before.E foo()");
        cmn.setName("bar");
        RefactorProcessor.run(cmn, "E.java");
    }
}
