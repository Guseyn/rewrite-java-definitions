package org.openrewrite.definitions;

import java.io.IOException;

public class RunAll {
    public static void main(String... args) throws IOException {
        new AddAnnotationExample().main();
        new AddLogger().main();
        new AddSerializable().main();
        new AddSetField().main();
        new BracketStringTemplates().main();
        new ChangeMethodNameExample().main();
        new ChangeTypeExample().main();
        new ComplexMethodTransformation().main();
        new DeleteMethodArgumentExample().main();
        new InsertMethodArgumentExample().main();
        new OrderImportsExample().main();
        new RemoveAnnotationExample().main();
        new ReorderMethodArgumentsExample().main();
        new UseStaticImportExample().main();
    }
}
