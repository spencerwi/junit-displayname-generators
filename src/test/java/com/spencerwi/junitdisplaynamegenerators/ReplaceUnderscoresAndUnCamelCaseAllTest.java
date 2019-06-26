package com.spencerwi.junitdisplaynamegenerators;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(ReplaceUnderscoresAndUnCamelCase.All.class)
class ReplaceUnderscoresAndUnCamelCaseAll_Test {
    private TestInfo classTestInfo;

    public ReplaceUnderscoresAndUnCamelCaseAll_Test(TestInfo testInfo) {
        this.classTestInfo = testInfo;
    }

    @Test
    void convertsCamelCaseMethodNames_ToSpaceSeparatedNames_ReplacingUnderscores(TestInfo testInfo) {
        assertEquals(
                "converts Camel Case Method Names To Space Separated Names Replacing Underscores",
                testInfo.getDisplayName()
        );
    }

    @Test
    void convertsCamelCaseClassNamesToSpaceSeparatedNames() {
        assertEquals(
            "Replace Underscores And Un Camel Case All Test",
            classTestInfo.getDisplayName()
        );
    }

    @Nested
    class NestedTest_Inside {
        private TestInfo nestedClassTestInfo;

        public NestedTest_Inside(TestInfo nestedClassTestInfo) {
            this.nestedClassTestInfo = nestedClassTestInfo;
        }

        @Test
        void convertsCamelCaseNestedClassNamesToSpaceSeparatedNames() {
            assertEquals(
                    "Nested Test Inside",
                    nestedClassTestInfo.getDisplayName()
            );
        }
    }
}