package com.cazucito.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day01 {

    public int task01() {
        final String dataFile = "src/main/resources/20211201_input.dat";
        int increments=0;
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            String dataStr = lines.collect(Collectors.joining("\n"));
            lines.close();
            System.out.println(dataStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return increments;
    }
}
