package com.spencerwi.junitdisplaynamegenerators;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(UnCamelCase.Methods.class)
class UnCamelCaseMethodsTest {

    private TestInfo classTestInfo;
    UnCamelCaseMethodsTest(TestInfo classTestInfo) {
        this.classTestInfo = classTestInfo;
    }

    @Test
    void convertsCamelCaseMethodNamesToSpaceSeparatedNames(TestInfo testInfo) {
        assertEquals(
            "converts Camel Case Method Names To Space Separated Names",
            testInfo.getDisplayName()
        );
    }

    @Test
    void leavesClassNamesAlone() {
        assertEquals(
            this.getClass().getSimpleName(),
            classTestInfo.getDisplayName()
        );
    }

    @Nested
    class NestedTest {

        private TestInfo nestedClassTestInfo;
        NestedTest(TestInfo nestedClassTestInfo) {
            this.nestedClassTestInfo = nestedClassTestInfo;
        }
        @Test
        void leavesNestedClassNamesAlone(TestInfo testInfo) {
            assertEquals(
                this.getClass().getSimpleName(),
                nestedClassTestInfo.getDisplayName()
            );
        }
    }
}