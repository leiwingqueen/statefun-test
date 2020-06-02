package com.liyongquan.flink;

import org.apache.flink.statefun.sdk.Address;
import org.apache.flink.statefun.sdk.FunctionType;

public class GreetingConstants {
    public static final Address GREETING_EGRESS_ID = new Address(new FunctionType("n1", "1"), "1");
}
