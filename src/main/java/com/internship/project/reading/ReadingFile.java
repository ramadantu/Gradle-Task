package com.internship.project.reading;

import com.internship.project.ProjectApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Objects;
import java.util.Queue;

public class ReadingFile {
    public void readingFile(Queue<String> inputQueue, Queue<String> outputQueue) throws IOException {

        try (InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(input)))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] arrayOfElementsPerLine = currentLine.substring(0, currentLine.indexOf("?")).split(" ");

                Collections.addAll(inputQueue, arrayOfElementsPerLine);
                Collections.addAll(outputQueue, arrayOfElementsPerLine);

            }

        }
    }

}

