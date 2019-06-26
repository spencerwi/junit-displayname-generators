package com.spencerwi.junitdisplaynamegenerators;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(UnCamelCase.All.class)
class UnCamelCaseAllTest {
    private TestInfo classTestInfo;

    public UnCamelCaseAllTest(TestInfo testInfo) {
        this.classTestInfo = testInfo;
    }

    @Test
    void convertsCamelCaseMethodNamesToSpaceSeparatedNames(TestInfo testInfo) {
        assertEquals(
            "converts Camel Case Method Names To Space Separated Names",
            testInfo.getDisplayName()
        );
    }

    @Test
    void convertsCamelCaseClassNamesToSpaceSeparatedNames() {
        assertEquals(
            "Un Camel Case All Test",
            classTestInfo.getDisplayName()
        );
    }

    @Nested
    class NestedTest {
        private TestInfo nestedClassTestInfo;

        public NestedTest(TestInfo nestedClassTestInfo) {
            this.nestedClassTestInfo = nestedClassTestInfo;
        }

        @Test
        void convertsCamelCaseNestedClassNamesToSpaceSeparatedNames() {
            assertEquals(
                    "Nested Test",
                    nestedClassTestInfo.getDisplayName()
            );
        }
    }
}