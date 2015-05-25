package com.umbrella.demo.akka.demo2.actor;

import akka.actor.UntypedActor;
import org.apache.log4j.Logger;

/**
 * Created by 大洲 on 15-4-15.
 */
public class GoodmorningActor extends UntypedActor {

    private static final Logger log = Logger.getLogger(GoodmorningActor.class);

    @Override
    public void onReceive(Object o) throws Exception {
        log.info("Good Morning!");
    }
}
