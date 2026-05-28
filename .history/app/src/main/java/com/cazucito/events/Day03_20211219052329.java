package com.cazucito.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Day03 {

    public int task01() {
        final String dataFile = "src/main/resources/20211203_input.poc";
        int powerConsumption = 0;
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder elipsonRate = new StringBuilder();
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();

            int zero = 0;
            int one = 0;

            for (int i = 0; i < data.size(); ++i) {
                String binData = data.get(i);

                switch(binData.charAt(0)) {
                    case '0':
                        zero++;
                        break;
                    case '1':
                        one++;
                        break;
                }
                if(zero>one) {
                    gammaRate.append("0");
                } else {
                    gammaRate.append("1");
                }
                //
            }
            //
            for(int i = 0; i < gammaRate.length(); i++) {
                if(gammaRate.charAt(i)=='0') {
                    elipsonRate.append("1");
                } else {
                    elipsonRate.append("0");
                }
            }
            powerConsumption = Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(elipsonRate.toString(), 2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return powerConsumption;
    }

    public int task02() {
        final String dataFile = "src/main/resources/20211202_input.dat";
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
                        horizontal += delta;
                        depth += delta*aim;
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
