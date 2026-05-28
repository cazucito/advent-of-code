package com.cazucito.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Day02 {

    public int task01() {
        final String dataFile = "src/main/resources/20211202_input.dat";
        int finalXY = 0;
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();

            int horizontal = 0;
            int depth = 0;

            for (int i = 0; i < data.size(); ++i) {
                String op = (data.get(i).split(" "))[0];
                int delta = Integer.parseInt((data.get(i).split(" "))[1]);

                switch (op) {
                    case "forward":
                        horizontal += delta;
                        break;
                    case "up":
                        depth -= delta;
                        break;
                    case "down":
                        depth += delta;
                        break;
                    // default:
                }

            }
            finalXY = horizontal *depth;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalXY;
    }

    public int task02() {
        final String dataFile = "src/main/resources/20211202_input_2.dat";
        int finalXY = 0;
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();

            int horizontal = 0;
            int depth = 0;
            int aim = 0;

            for (int i = 0; i < data.size(); ++i) {
                String op = (data.get(i).split(" "))[0];
                int delta = Integer.parseInt((data.get(i).split(" "))[1]);

                switch (op) {
                    case "forward":
                        horizontal += delta*aim;
                        break;
                    case "up":
                        aim -= delta;
                        break;
                    case "down":
                        aim += delta;
                        break;
                    // default:
                }

            }
            finalXY = horizontal * depth;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalXY;
    }
}
