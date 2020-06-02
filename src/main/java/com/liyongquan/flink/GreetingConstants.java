package com.liyongquan.flink;

import org.apache.flink.statefun.sdk.Address;
import org.apache.flink.statefun.sdk.FunctionType;

public class GreetingConstants {
    public static final FunctionType GREETER_FUNCTION_TYPE=new FunctionType("GreetRequest#getWho","1");
    public static final Address GREETING_EGRESS_ID = new Address(GREETER_FUNCTION_TYPE, "1");
}
