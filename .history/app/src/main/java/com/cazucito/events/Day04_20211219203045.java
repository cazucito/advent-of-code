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
        int powerConsumption = 0;
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder elipsonRate = new StringBuilder();
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return powerConsumption;
    }

    public int task02() {
 
        return 2;
    }
  
}
