package com.cazucito.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day01 {

    public int task01() {
        final String dataFile = "src/main/resources/20211201_input.dat";
        int increments=0;
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            // String dataStr = lines.collect(Collectors.joining("\n"));
            lines.close();
            for(int i = 0; i < data.size()-1; ++i) {
                int first = Integer.parseInt(data.get(i));
                int second = Integer.parseInt(data.get(i+1));
                if(second > first) {
                    increments++;
                }
                System.err.println("i:"+1);
            }
            System.out.println(increments);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return increments;
    }
}
