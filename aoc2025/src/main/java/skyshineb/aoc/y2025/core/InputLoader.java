package skyshineb.aoc.y2025.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class InputLoader {

    public Input readFile(String inputPath) {
        String normalized = normalize(inputPath);
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try (InputStream is = cl.getResourceAsStream(normalized)) {
            if (is == null) {
                throw new IllegalArgumentException("Resource not found on classpath: " + normalized);
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return new Input(content);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read resource: " + normalized, e);
        }
    }

    private String normalize(String input) {
        String p = Objects.requireNonNull(input, "resourcePath must not be null").trim();

        while (p.startsWith("/")) {
            p = p.substring(1);
        }
        return p;
    }
}
