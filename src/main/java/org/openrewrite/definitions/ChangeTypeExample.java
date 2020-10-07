package org.openrewrite.definitions;

import java.io.IOException;
import org.openrewrite.java.ChangeType;
import org.openrewrite.refactor.RefactorProcessor;

public class ChangeTypeExample {
    public static void main(String... args) throws IOException {
        ChangeType ct = new ChangeType();
        ct.setType("java.util.List");
        ct.setTargetType("java.util.Collection");
        RefactorProcessor.run(ct, "F.java");
    }
}
