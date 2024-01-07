import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    enum Direction {
        DOWN, RIGHT, DIAGONAL, NEGATIVE
    }

    private static Set<Coordinate> generateWordCoordinates(Coordinate initial, int length, Direction direction) {
        Set<Coordinate> coordinates = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int x = initial.x, y = initial.y;

            switch (direction) {
                case DOWN:
                    x += i;
                    break;
                case RIGHT:
                    y += i;
                    break;
                case DIAGONAL:
                    x += i;
                    y += i;
                    break;
            }

            if (x < 0 || y < 0 || x >= 10 || y >= 10) {
                return new HashSet<>();
            }

            coordinates.add(new Coordinate(x, y));
        }
        return coordinates;
    }

    private static void placeWordsOnBoard(Board board, Set<String> words) {
        Scanner scanner = new Scanner(System.in);
        for (String word : words) {
            boolean placed = false;
            while (!placed) {
                board.printBoard();
                System.out.println("Placing word: " + word);
                System.out.print("Enter x coordinate: ");
                int x = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter y coordinate: ");
                int y = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                System.out.print("Enter direction (DOWN, RIGHT, DIAGONAL): ");
                String dirInput = scanner.nextLine().toUpperCase();
                Direction direction;
                try {
                    direction = Direction.valueOf(dirInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid direction. Please try again.");
                    continue;
                }

                Set<Coordinate> coordinates = generateWordCoordinates(new Coordinate(y, x), word.length(), direction);
                if (board.canPlaceWord(coordinates, word)) {
                    board.placeWord(coordinates, word);
                    placed = true;
                } else {
                    System.out.println("Cannot place word there. Try again.");
                }
            }
        }
    }

    private static Set<String> listOfWords() {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();
        System.out.print("Enter the number of words: ");
        int numberOfWords = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String word = scanner.nextLine();
            words.add(word);
        }

        return words;
    }

    public static void main(String[] args) {
        Set<String> words = listOfWords(); 
        Board board = new Board(words, null); 
        placeWordsOnBoard(board, words); 
        board.fillWords();
        board.printBoard();
    }
}
