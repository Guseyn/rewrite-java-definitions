package org.openrewrite.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class I {
    public void foo() {
        Logger logger = LoggerFactory.getLogger(G.class);
        logger.debug("message");
    }
}
