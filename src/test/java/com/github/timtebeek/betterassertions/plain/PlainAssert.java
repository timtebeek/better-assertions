package com.github.timtebeek.betterassertions.plain;

public class PlainAssert {

    public static void main(String[] args) {
        // Only supports booleans; supports a message
        assert args != null : "args should not be null";
        assert args.length > 0 : "args should not be empty";

        System.out.println("args[0] = " + args[0]);
    }

    // Execute assertions
    // java -ea src/test/java/com/github/timtebeek/betterassertions/plain/PlainAssert.java

    // Volkswagen mode by default, or when -da is used
    // java src/test/java/com/github/timtebeek/betterassertions/plain/PlainAssert.java
    // java -da src/test/java/com/github/timtebeek/betterassertions/plain/PlainAssert.java
}
