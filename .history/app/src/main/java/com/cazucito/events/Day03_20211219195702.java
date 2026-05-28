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

public class Day03 {

    public int task01() {
        final String dataFile = "src/main/resources/20211203_input.dat";
        int powerConsumption = 0;
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder elipsonRate = new StringBuilder();
        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();

            int[][] t = new int[2][data.get(0).length()];
            for (int i = 0; i < data.size(); i++) {
                String binData = data.get(i);
                for (int j = 0; j < binData.length(); j++) {
                    switch (binData.charAt(j)) {
                        case '0':
                            t[0][j]++;
                            break;
                        case '1':
                            t[1][j]++;
                            break;
                    }
                }

            }
            // System.out.println("t:"+Arrays.deepToString(t));
            for (int i = 0; i < t[0].length; i++) {
                if (t[0][i] > t[1][i]) {
                    gammaRate.append("0");
                } else {
                    gammaRate.append("1");
                }
            }
            //
            for (int i = 0; i < gammaRate.length(); i++) {
                if (gammaRate.charAt(i) == '0') {
                    elipsonRate.append("1");
                } else {
                    elipsonRate.append("0");
                }
            }
            // System.out.println("gammaRate:"+gammaRate);
            powerConsumption = Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(elipsonRate.toString(), 2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return powerConsumption;
    }

    public int task02() {
        // final String dataFile = "src/main/resources/20211203_input.poc";
        final String dataFile = "src/main/resources/20211203_input.dat";
        Path path = Paths.get(dataFile);
        int lifeSupportRating = 0;
        try {
            Stream<String> lines = Files.lines(path);
            List<String> data = lines.toList();
            lines.close();
            final int WORD_SIZE = data.get(0).length();

            List<String> binDataO2 = new ArrayList<>(data);
            for (int i = 0; i < WORD_SIZE; i++) {
                char mostCommonBit = getMostCommonBitInPosition(binDataO2, i);
                System.out.println("----mostCommonBit:" + i + "/" + mostCommonBit);
                final int iTemp = i;

                if (binDataO2.size() == 2) {
                    binDataO2 = binDataO2.stream().filter(binData -> binData.charAt(iTemp) == '1')
                            .collect(Collectors.toList());
                    break;
                } else if (binDataO2.size() == 1) {
                    binDataO2 = binDataO2.stream().collect(Collectors.toList());
                    break;
                } else {
                    binDataO2 = binDataO2.stream().filter(binData -> binData.charAt(iTemp) == mostCommonBit)
                            .collect(Collectors.toList());
                }
            }
            //
            List<String> binDataCO2 = new ArrayList<>(data);
            for (int i = 0; i < WORD_SIZE; i++) {
                char lessCommonBit = getLessCommonBitInPosition(binDataCO2, i);
                System.out.println("----lessCommonBit:" + i + "/" + lessCommonBit);
                final int iTemp = i;

                if (binDataCO2.size() == 2) {
                    binDataCO2 = binDataCO2.stream().filter(binData -> binData.charAt(iTemp) == '0')
                            .collect(Collectors.toList());
                    break;
                } else if (binDataCO2.size() == 1) {
                    binDataCO2 = binDataCO2.stream().collect(Collectors.toList());
                    break;
                } else {
                    binDataCO2 = binDataCO2.stream().filter(binData -> binData.charAt(iTemp) == lessCommonBit)
                            .collect(Collectors.toList());
                }
            }

            final int oxygenGeneratorRating = Integer.parseInt(binDataO2.get(0), 2);
            //
            final int co2ScrubberRating = Integer.parseInt(binDataCO2.get(0), 2);
            //
            lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;
            System.out.println("binDataO2/oxygenGeneratorRating: " + binDataO2 + "/" + oxygenGeneratorRating);
            System.out.println("binDataCO2/co2ScrubberRating: " + binDataCO2 + "/" + co2ScrubberRating);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lifeSupportRating;
    }

    //
    public char getMostCommonBitInPosition(List<String> data, int pos) {
        char mostCommonBit = '2';
        int zero = 0;
        int one = 0;
        System.out.println("data: " + data);
        for (int i = 0; i < data.size(); i++) {
            String binData = data.get(i);
            switch (binData.charAt(pos)) {
                case '0':
                    zero++;
                    break;
                case '1':
                    one++;
                    break;
            }
        }
        if (zero > one) {
            mostCommonBit = '0';
        } else if (one > zero) {
            mostCommonBit = '1';
        }
        return mostCommonBit;
    }

    //
    //
    public char getLessCommonBitInPosition(List<String> data, int pos) {
        char lessCommonBit = '2';
        int zero = 0;
        int one = 0;
        System.out.println("data: " + data);
        for (int i = 0; i < data.size(); i++) {
            String binData = data.get(i);
            switch (binData.charAt(pos)) {
                case '0':
                    zero++;
                    break;
                case '1':
                    one++;
                    break;
            }
        }
        if (zero < one) {
            lessCommonBit = '0';
        } else if (one < zero) {
            lessCommonBit = '1';
        }
        return lessCommonBit;
    }
}
