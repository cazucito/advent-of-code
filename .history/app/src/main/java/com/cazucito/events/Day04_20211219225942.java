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
         List<BingoBoard> boards = getBoards(data, 2);
        boards.forEach(BingoBoard::printBoard);



        return 1;
    }

    private 

    private List<BingoBoard> getBoards(final List<String> data, final int initialPosition) {
        List<BingoBoard> boards = new ArrayList<>();
        System.out.println("dataSize:" + data.size());
        for (int i = 0; i < (data.size() - initialPosition); i = i + 6) {
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
    final private int ROWS = 5;
    final private int COLUMNS = 5;
    private int[][] dataBoard;
    private int[][] dataMoves = new int[ROWS][COLUMNS];
    //
    public BingoBoard(final int[][] dataBoard) {
        this.dataBoard = dataBoard;
    }

    //
    public void printBoard() {
        StringBuilder board2Screen = new StringBuilder(100);
        for(int i = 0; i < dataBoard[0].length; i++) {
            int[] row = dataBoard[i];
            for(int j = 0; j < row.length; j++) {
                board2Screen.append(row[j]);
                board2Screen.append(" ");
            }
            board2Screen.append("\n");
        }
        System.out.println(board2Screen);
        System.out.println();
    }
    //
    public String toString() {
        return Arrays.deepToString(dataBoard);
    }
}