package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.OrderImports;
import org.openrewrite.refactor.RefactorProcessor;

public class OrderImportsExample {
    public static void main(String... args) throws IOException {
        OrderImports ori = new OrderImports();
        ori.setRemoveUnused(true);
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(ori);
        }}, "J.java");
    }
}
