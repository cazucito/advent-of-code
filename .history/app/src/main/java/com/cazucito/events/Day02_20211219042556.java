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
        final String dataFile = "src/main/resources/20211201_input.dat";
        int increments = 0;
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            // String dataStr = lines.collect(Collectors.joining("\n"));
            lines.close();
            for (int i = 0; i < data.size() - 3; ++i) {
                int first = Integer.parseInt(data.get(i));
                int second = Integer.parseInt(data.get(i + 1));
                int third = Integer.parseInt(data.get(i + 2));
                int fourth = Integer.parseInt(data.get(i + 3));

                int a = first + second + third;
                int b = second + third + fourth;

                if (b > a) {
                    increments++;
                }
                System.err.print("i:" + i);
            }
            System.out.println(increments);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return increments;
    }
}
