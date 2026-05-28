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
        // board1[0] = Arrays.stream((data.get(2).split("
        // "))).mapToInt(Integer::parseInt).toArray();
        System.out.println("board1: " + getBoards(data, 2));

        // board1[1] = Arrays.stream((data.get(3).split("
        // "))).mapToInt(Integer::parseInt).toArray();
        // board1[2] = Arrays.stream((data.get(4).split("
        // "))).mapToInt(Integer::parseInt).toArray();
        // board1[3] = Arrays.stream((data.get(5).split("
        // "))).mapToInt(Integer::parseInt).toArray();
        // board1[4] = Arrays.stream((data.get(6).split("
        // "))).mapToInt(Integer::parseInt).toArray();
        BingoBoard bingoBoard01 = new BingoBoard(board1);
        bingoBoard01.printBoard();

        return 1;
    }

    private List<BingoBoard> getBoards(final List<String> data, final int initialPosition) {
        List<BingoBoard> boards = new ArrayList<>();
        System.out.println("dataSize:" + data.size());
        for (int i = 0; i < (data.size() - initialPosition); i++) {
            boards.add(new BingoBoard(getDataBoard5x5(data, initialPosition + i)));
        }
        return boards;
    }

    private int[][] getDataBoard5x5(final List<String> data, final int initialPosition) {
        final int ROWS = 5;
        int[][] dataBoard5x5 = new int[ROWS][];
        for (int i = 0; i < ROWS; i++) {
            List<String> l1 = new ArrayList<>(Arrays.asList(data.get(initialPosition + i).split(" ")));
            l1.removeIf(d -> d.equals(""));
            dataBoard5x5[i] = l1.stream().mapToInt(Integer::parseInt).toArray();
        }
        return dataBoard5x5;
    }

    public int task02() {

        return 2;
    }

}

class BingoBoard {
    private int[][] dataBoard;

    //
    public BingoBoard(final int[][] dataBoard) {
        this.dataBoard = dataBoard;
    }

    //
    public void printBoard() {
        System.out.println(Arrays.toString(dataBoard));
    }
    //
    public String toString() {
        return Arrays.toString(dataBoard);
    }
}