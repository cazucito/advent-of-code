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
        List<String> data;
        final int[] moves;

        Path path = Paths.get(dataFile);
        try {
            Stream<String> lines = Files.lines(path);
            data = lines.toList();
            lines.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            data = null;
            e.printStackTrace();
        }
        // MOVES          
        moves = Arrays.stream((data.get(0).split(","))).mapToInt(Integer::parseInt).toArray();
        System.out.println("moves:" + Arrays.toString(moves));
        // BOARDS
        int[][] board1 = new int[5][];
        board1[0] = Arrays.stream((data.get(2).split(" "))).mapToInt(Integer::parseInt).toArray();
        System.out.println("board1: " + Arrays.toString(board1));
        board1[1] = Arrays.stream((data.get(3).split(" "))).mapToInt(Integer::parseInt).toArray();
        board1[2] = Arrays.stream((data.get(4).split(" "))).mapToInt(Integer::parseInt).toArray();
        board1[3] = Arrays.stream((data.get(5).split(" "))).mapToInt(Integer::parseInt).toArray();
        board1[4] = Arrays.stream((data.get(6).split(" "))).mapToInt(Integer::parseInt).toArray();
        BingoBoard bingoBoard01 = new BingoBoard(board1);
        bingoBoard01.printBoard();

        return 1;
    }

    public int task02() {
 
        return 2;
    }
  
}

class BingoBoard{
    private int[][] dataBoard;
    //
    public BingoBoard(final int[][] dataBoard) {
        this.dataBoard = dataBoard;
    }
    //
    public void printBoard() {
        System.out.println(Arrays.toString(dataBoard));
    }
}