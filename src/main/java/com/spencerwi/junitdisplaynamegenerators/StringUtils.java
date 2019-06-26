package com.spencerwi.junitdisplaynamegenerators;

class StringUtils {
    static String deCamelize(String input) {
        if (input == null) { return null; }
        return input.replaceAll("[A-Z]", " $0")
                .replaceAll("  ", " ")
                .trim();
    }

    static String replaceUnderscoresAndDeCamelize(String input) {
        if (input == null) { return null; }
        return input.replaceAll("[A-Z]", " $0")
                .replaceAll("_", " ")
                .replaceAll("  ", " ")
                .trim();
    }
}
