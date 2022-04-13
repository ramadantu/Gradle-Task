package com.internship.project.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class WritingFile {
    public void writingFile(Queue<String> outputQueue, Queue<String> results) throws IOException {

        File outputFile = new File("Task5.2/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        try (fileWriter; BufferedWriter writer = new BufferedWriter(fileWriter)) {
            while (outputQueue.peek() != null) {
                if (outputQueue.peek().equals("=")) {
                    writer.write(outputQueue.remove() + " " + results.remove() + "\n");
                } else {
                    writer.write(outputQueue.remove() + " ");
                }
            }
        }

    }
}