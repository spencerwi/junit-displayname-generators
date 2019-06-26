package com.spencerwi.junitdisplaynamegenerators;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

import static com.spencerwi.junitdisplaynamegenerators.StringUtils.deCamelize;

public class UnCamelCase {

    public static class Methods extends DisplayNameGenerator.Standard {
        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return deCamelize(testMethod.getName());
        }
    }

    public static class All extends DisplayNameGenerator.Standard {
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return deCamelize(super.generateDisplayNameForClass(testClass));
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return deCamelize(super.generateDisplayNameForNestedClass(nestedClass));
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return deCamelize(testMethod.getName());
        }
    }
}
