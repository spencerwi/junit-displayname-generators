package com.spencerwi.junitdisplaynamegenerators;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

import static com.spencerwi.junitdisplaynamegenerators.StringUtils.replaceUnderscoresAndDeCamelize;

public class ReplaceUnderscoresAndUnCamelCase {

    public static class Methods extends DisplayNameGenerator.Standard {
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return replaceUnderscoresAndDeCamelize(testMethod.getName());
        }
    }

    public static class All extends DisplayNameGenerator.Standard {
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return replaceUnderscoresAndDeCamelize(super.generateDisplayNameForClass(testClass));
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return replaceUnderscoresAndDeCamelize(super.generateDisplayNameForNestedClass(nestedClass));
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return replaceUnderscoresAndDeCamelize(testMethod.getName());
        }
    }

}
