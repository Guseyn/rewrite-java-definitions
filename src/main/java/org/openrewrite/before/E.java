package org.openrewrite.before;

import org.openrewrite.classes.ClassWithMethods;

public class E  {
    void foo() {
        // new ClassWithMethods().foo();
        ClassWithMethods.fooStatic();
    }
}
