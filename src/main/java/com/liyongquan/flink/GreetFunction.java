package com.liyongquan.flink;

import com.liyongquan.flink.Greeting.GreetRequest;
import com.liyongquan.flink.Greeting.GreetResponse;
import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.StatefulFunction;

public final class GreetFunction implements StatefulFunction {
    @Override
    public void invoke(Context context, Object input) {
        GreetRequest greetMessage = (GreetRequest) input;

        GreetResponse response = GreetResponse.newBuilder()
                .setWho(greetMessage.getWho())
                .setGreeting("Hello " + greetMessage.getWho())
                .build();

        context.send(GreetingConstants.GREETING_EGRESS_ID, response);
    }

    private static String greetText(String name, int seen) {
        switch (seen) {
            case 0:
                return String.format("Hello %s !", name);
            case 1:
                return String.format("Hello again %s !", name);
            case 2:
                return String.format("Third times the charm! %s!", name);
            case 3:
                return String.format("Happy to see you once again %s !", name);
            default:
                return String.format("Hello at the %d-th time %s", seen + 1, name);
        }
    }
}
