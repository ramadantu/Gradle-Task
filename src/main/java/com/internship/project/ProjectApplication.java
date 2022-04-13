package com.internship.project;

import com.internship.project.calculating.RpnCalculator;
import com.internship.project.converting.RpnConverter;
import com.internship.project.reading.ReadingFile;
import com.internship.project.writing.WritingFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> inputQueue = new LinkedList<>();
        Queue<String> outputQueue = new LinkedList<>();
        new ReadingFile().readingFile(inputQueue, outputQueue);

        RpnConverter rpnConverter = new RpnConverter();
        Queue<String> rpnQueue = rpnConverter.convert(inputQueue);

        RpnCalculator rpnCalculator = new RpnCalculator();
        Queue<String> results = rpnCalculator.calculate(rpnQueue);

        new WritingFile().writingFile(outputQueue, results);

    }
}