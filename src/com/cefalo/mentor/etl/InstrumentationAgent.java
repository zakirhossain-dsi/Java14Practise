package com.cefalo.mentor.etl;

import java.lang.instrument.Instrumentation;

public class InstrumentationAgent {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }

    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().freeMemory());
        String s = new String("Zakir");
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
