package org.openrewrite.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class G {
    public void foo() {
        Logger logger = LoggerFactory.getLogger(G.class);
        logger.debug( "message");
    }
}
