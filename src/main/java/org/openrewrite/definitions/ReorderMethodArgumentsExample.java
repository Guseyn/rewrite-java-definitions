package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.ReorderMethodArguments;
import org.openrewrite.refactor.RefactorProcessor;

public class ReorderMethodArgumentsExample {
    public static void main(String... args) throws IOException {
        ReorderMethodArguments rma = new ReorderMethodArguments();
        rma.setMethod("org.openrewrite.examplellib.Robot move(String, int, boolean)");
        rma.setOrder("sleepAfter", "pattern", "offset");
        rma.setOriginalOrder("pattern", "offset", "sleepAfter"); // optional
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(rma);
        }}, "K.java");
    }
}
