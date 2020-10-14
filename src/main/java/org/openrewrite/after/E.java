package org.openrewrite.after;

import org.openrewrite.classes.ClassWithMethods;

public class E  {
    void foo() {
        new ClassWithMethods().bar();
        ClassWithMethods.barStatic();
    }
}
