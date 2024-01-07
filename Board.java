import java.util.Set;
import java.util.Random;

public class Board {
    private String[][] board;
    private Set<String> words;
    private int size;

    public Board(Set<String> words, Integer customSize) {
        this.words = words;
        this.size = (customSize != null) ? customSize : determineBoardSize();
        this.board = new String[size][size];
        initializeBoard();
    }

    private int determineBoardSize() {
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        return Math.max(10, maxLength); // Ensuring a minimum size of 10
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "_";
            }
        }
    }

    public void printBoard() {
        printHeader();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "     ");
            }
            System.out.println("\n");
        }
    }

    private void printHeader() {
        String output = "  ";
        for (int i = 0; i < size; i++) {
            output = output + i + "     ";
        }
        System.out.println(output);
    }

    public boolean canPlaceWord(Set<Coordinate> positions, String word) {
        if (!isValidPlacement(positions, word)) {
            return false;
        }

        int i = 0;
        for (Coordinate position : positions) {
            if (!"_".equals(board[position.x][position.y]) && 
                !board[position.x][position.y].equals(String.valueOf(word.charAt(i)))) {
                return false; // Overlapping letter does not match
            }
            i++;
        }
        return true;
    }

    public void placeWord(Set<Coordinate> positions, String word) {
        int i = 0;
        for (Coordinate position : positions) {
            board[position.x][position.y] = String.valueOf(word.charAt(i++));
        }
    }

    public boolean isValidPlacement(Set<Coordinate> positions, String word) {
        int wordLength = word.length();
        return isWithinBounds(positions) && (isContinuous(positions, wordLength) || isDiagonal(positions));
    }

    private boolean isWithinBounds(Set<Coordinate> positions) {
        for (Coordinate position : positions) {
            if (position.x < 0 || position.x >= size || position.y < 0 || position.y >= size) {
                return false;
            }
        }
        return true;
    }

    private boolean isContinuous(Set<Coordinate> positions, int wordLength) {
        return positions.size() == wordLength;
    }

    private boolean isDiagonal(Set<Coordinate> positions) {
        int prevX = -1, prevY = -1;
        for (Coordinate position : positions) {
            if (prevX != -1 && prevY != -1) {
                if (Math.abs(position.x - prevX) != 1 || Math.abs(position.y - prevY) != 1) {
                    return false;
                }
            }
            prevX = position.x;
            prevY = position.y;
        }
        return true;
    }

    public void fillWords() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ("_".equals(board[i][j])) {
                    char randomChar = (char) ('a' + random.nextInt(26)); // Random letter from A to Z
                    board[i][j] = String.valueOf(randomChar);
                }
            }
        }
    }
}
