package com.fabian.osorio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    @Test
    void writeStringAndReadStringMethods() throws IOException {
        Path filePath = Files.writeString(Files.createTempFile("test1", ".txt"), "Hello word");
        System.out.println(filePath.toAbsolutePath());
        String fileContent = Files.readString(filePath);
        assertEquals(fileContent, "Hello word");
    }

    @Test
    void writeStringAndReadWithCharsetMethods() throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Files.writeString(Files.createTempFile("test1", ".txt"), "Hello word", charset);
        System.out.println(filePath.toAbsolutePath());
        String fileContent = Files.readString(filePath, charset);
        assertEquals(fileContent, "Hello word");
    }
}
