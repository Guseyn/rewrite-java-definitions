package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.AddImport;
import org.openrewrite.java.InsertMethodArgument;
import org.openrewrite.refactor.RefactorProcessor;

public class InsertMethodArgumentExample {
    public static void main(String... args) throws IOException {
        InsertMethodArgument ima = new InsertMethodArgument();
        ima.setMethod("org.slf4j.Logger debug(String,..)");
        ima.setIndex(0);
        ima.setSource("MarkerFactory.getMarker(\"CONFIDENTIAL\")");
        AddImport adi = new AddImport();
        adi.setType("org.slf4j.MarkerFactory");
        adi.validate();
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(ima);
            add(adi);
        }}, "I.java");
    }
}
