package com.cazucito.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {

    public int task01() {
        final String dataFile = "src/main/resources/20211204_input.poc";
        final List<String> data;
        final int[] moves;

        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            data = lines.toList();
            lines.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //          
        moves = (data.get(0).split(",")).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println("moves:" + moves);
        return powerConsumption;
    }

    public int task02() {
 
        return 2;
    }
  
}
