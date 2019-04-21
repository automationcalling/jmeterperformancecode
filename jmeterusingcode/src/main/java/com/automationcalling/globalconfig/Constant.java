package com.automationcalling.globalconfig;

public class Constant {

    public static String performanceConfig="src/main/resources/propfile/PerformanceConfig.properties";
    public static String jmxFILEPath="src/main/resources/jmxfiles/";
    public static String loop="//hashTree/ThreadGroup/elementProp/stringProp[@name='LoopController.loops']";
    public static String threads="//hashTree/ThreadGroup/stringProp[@name='ThreadGroup.num_threads']";
    public static String Rampup="//hashTree/ThreadGroup/stringProp[@name='ThreadGroup.ramp_time']";
}
