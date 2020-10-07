package org.openrewrite.before;

import org.openrewrite.examplellib.Robot;

public class K {
    public void foo() {
        Robot.move("up left down right", 3, true);
    }
}
