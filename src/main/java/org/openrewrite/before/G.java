package org.openrewrite.before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class G {
    public void foo() {
        Logger logger = LoggerFactory.getLogger(G.class);
        logger.debug(MarkerFactory.getMarker("CONFIDENTIAL"), "message");
    }
}
