package com.liyongquan.flink;

import com.liyongquan.flink.Greeting.GreetRequest;
import org.apache.flink.statefun.sdk.io.Router;

public final class GreetRouter implements Router<GreetRequest> {
    @Override
    public void route(GreetRequest message, Downstream<GreetRequest> downstream) {
        downstream.forward(GreetingConstants.GREETER_FUNCTION_TYPE, message.getWho(), message);
    }
}
