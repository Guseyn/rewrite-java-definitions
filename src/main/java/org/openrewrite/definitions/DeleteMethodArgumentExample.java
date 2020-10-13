package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.DeleteMethodArgument;
import org.openrewrite.java.RemoveImport;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class DeleteMethodArgumentExample {
    public static void main(String... args) throws IOException {
        DeleteMethodArgument dma = new DeleteMethodArgument();
        dma.setMethod("org.slf4j.Logger debug(org.slf4j.Marker,..)");
        dma.setIndex(0);
        RemoveImport rmi = new RemoveImport();
        rmi.setType("org.slf4j.MarkerFactory");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(dma);
            add(rmi);
            add(cpn);
        }}, "G.java");
    }
}
