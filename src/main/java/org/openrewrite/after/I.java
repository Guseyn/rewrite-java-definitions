package org.openrewrite.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class I {
    public void foo() {
        Logger logger = LoggerFactory.getLogger(G.class);
        logger.debug(MarkerFactory.getMarker("CONFIDENTIAL"), "message");
    }
}
