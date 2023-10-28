package com.fabian.osorio;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class StringTest {

    @Test
    void isBlankMethod() {
        String blank = "   ";
        String empty = "";

        assertTrue(blank.isBlank());
        assertTrue(empty.isBlank());
    }

    @Test
    void linesMethod(){
        String example1 = "hello\nworld\rhow\nare\nyou";
        String exampleEmpty = "";
        String exampleBlankWithLines = "\n\n\n";

        Function<String, Long> countLines = value -> value.lines().count();

        var numberOfLinesExample1 = countLines.apply(example1);
        var numberOfLinesExampleEmpty = countLines.apply(exampleEmpty);
        var numberOfLinesExampleBlankWithLines = countLines.apply(exampleBlankWithLines);

        assertEquals(5, numberOfLinesExample1);
        assertEquals(0, numberOfLinesExampleEmpty);
        assertEquals(3, numberOfLinesExampleBlankWithLines);

        assertThrows(NullPointerException.class, () -> countLines.apply(null));
    }

    @Test
    void stripMethods(){
        String value = " hello word   ";
        assertEquals("hello word", value.strip());
        assertEquals("hello word   ", value.stripLeading());
        assertEquals(" hello word", value.stripTrailing());
    }

    @Test
    void repeatMethod(){
        String hello = "hello";
        assertEquals("hellohellohello", hello.repeat(3));
    }
}
