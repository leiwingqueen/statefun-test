package com.liyongquan.flink;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.StatefulFunction;

public final class GreetFunction implements StatefulFunction {
    @Override
    public void invoke(Context context, Object o) {
        GreetRequest greetMessage = (GreetRequest) input;

        GreetResponse response = GreetResponse.newBuilder()
                .setWho(greetMessage.getWho())
                .setGreeting("Hello " + greetMessage.getWho())
                .build();

        context.send(GreetingConstants.GREETING_EGRESS_ID, response);
    }
}
