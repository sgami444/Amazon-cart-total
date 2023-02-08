package com.amazon.config;
//  Configurations of everything where we usually keep hard coded things, like url and wait time
//  It should be public, static final with upper case letters

//  Since it is public, it will be available to every class in this project
public class Configs {
    public static final String CHROME_BROWSER = "chrome";
    public static final String EDGE_BROWSER = "edge";
    public static final String FIREFOX_BROWSER = "firefox";
    public static final String URL="https://amazon.com";
    public static final long MED_WAIT = 10L;
    public static final long LONG_WAIT = 30L;
}
