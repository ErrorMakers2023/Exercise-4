package de.uni_passau.aj.exercise3.wc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
class WordCounterTest {

    @Test
    void testCountWords() throws IOException {
        // Arrange
        List<String> lines = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Path.of("src/main/resources/alice.txt"));
        IntStream.range(0, 200).forEach(i -> lines.addAll(fileLines));
        long before = System.currentTimeMillis();
        // Act
        long numWords = WordCounter.countWords(lines);
        log.info("Counted {} words in {} ms", numWords, System.currentTimeMillis() - before);
        // Assert
        Assertions.assertEquals(6504000, numWords, "200 times the words in alice.txt should be 6504000");
    }
}
