package org.openrewrite.definitions;

import java.io.IOException;
import java.util.ArrayList;
import org.openrewrite.RefactorVisitor;
import org.openrewrite.java.AddImport;
import org.openrewrite.java.InsertMethodArgument;
import org.openrewrite.refactor.RefactorProcessor;
import org.openrewrite.visitors.ChangePackageName;

public class InsertMethodArgumentExample {
    public static void main(String... args) throws IOException {
        InsertMethodArgument ima = new InsertMethodArgument();
        ima.setMethod("org.slf4j.Logger debug(String,..)");
        ima.setIndex(0);
        ima.setSource("MarkerFactory.getMarker(\"CONFIDENTIAL\")");
        ChangePackageName cpn = new ChangePackageName();
        cpn.setNewPackageName("org.openrewrite.after");
        AddImport adi = new AddImport();
        adi.setType("org.slf4j.MarkerFactory");
        adi.setOnlyIfReferenced(false);
        RefactorProcessor.run(new ArrayList<RefactorVisitor<?>>(){{
            add(ima);
            add(adi);
            add(cpn);
        }}, "I.java");
    }
}
