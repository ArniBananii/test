import java.util.Random;

public class ZeroPlacement {
    // places 4 random spots
    public static char[][] placeZeroes(char[][] board) {
        Random rand = new Random();
        int placed = 0;
        while (placed < 4) {
            int x = rand.nextInt(5);
            int y = rand.nextInt(5);
            if (board[x][y] != 'o'
                    && (x - 1 < 0 || board[x - 1][y] != 'o')
                    && (x + 1 > 4 || board[x + 1][y] != 'o')
                    && (y - 1 < 0 || board[x][y - 1] != 'o')
                    && (y + 1 > 4 || board[x][y + 1] != 'o')) {
                board[x][y] = 'o';
                placed++;
            }
        }
        return board;
    }

    // new version to place 4 connected x
    // public static char[][] placeConnectedXsNextToOs(char[][] board) {
    // int placed = 0;
    // int x = (int) (Math.random() * 5);
    // int y = (int) (Math.random() * 5);
    // char[][] newBoard = board;
    // while (placed < 4) {

    // // check in upper left && right and below != 'o'
    // if (x > 0 && y > 0 && newBoard[x][y] != 'o' && newBoard[x++][y] != 'o' &&
    // newBoard[x][y++] != 'o') {
    // newBoard[x][y] = 'o';
    // int extraPos = 0;
    // // places 3 extra treasures
    // while (extraPos < 1) {
    // if (newBoard[x++][y] != 'o') {
    // newBoard[x][y] = 'o';
    // extraPos++;
    // // or places them below if next to it cant be done
    // } else if (x > 0 && y > 0 && newBoard[x++][y] == '0' && newBoard[x][y++] !=
    // 'o') {
    // newBoard[x][y++] = '0';
    // extraPos++;
    // } else {
    // placeConnectedXsNextToOs(board);
    // }
    // }
    // // check in lower left && right and above !- '0'
    // }
    // if (x > 0 && y < 4 && newBoard[x][y] != 'o' && newBoard[x++][y] != 'o' &&
    // newBoard[x][y--] != '0') {

    // }
    // }
    // // ! muss weg
    // return board;
    // }

    // old version!
    public static char[][] placeConnectedX(char[][] board) {
        Random rand = new Random();
        int placed = 0;
        int x = rand.nextInt(5);
        int y = rand.nextInt(5);
        boolean isRow = rand.nextBoolean();
        while (placed < 4) {
            if (isRow) {
                if (y < 4 && board[x][y] != 'o' && board[x][y] != 'x'
                        && (y - 1 < 0 || board[x][y - 1] != 'o')
                        && (x - 1 < 0 || board[x - 1][y] != 'o')
                        && (x + 1 > 4 || board[x + 1][y] != 'o')
                        && board[x][y + 1] != 'o' && board[x][y + 1] != 'x'
                        && (x - 1 < 0 || board[x - 1][y + 1] != 'o')
                        && (x + 1 > 4 || board[x + 1][y + 1] != 'o')) {
                    board[x][y] = 'x';
                    board[x][y + 1] = 'x';
                    placed += 2;
                    y += 2;
                } else {
                    isRow = false;
                    x = rand.nextInt(5);
                    y = rand.nextInt(5);
                }
            } else {
                if (x < 4 && board[x][y] != 'o' && board[x][y] != 'x'
                        && (x - 1 < 0 || board[x - 1][y] != 'o')
                        && (y - 1 < 0 || board[x][y - 1] != 'o')
                        && (y + 1 > 4 || board[x][y + 1] != 'o')
                        && board[x + 1][y] != 'o' && board[x + 1][y] != 'x'
                        && (y - 1 < 0 || board[x + 1][y - 1] != 'o')
                        && (y + 1 > 4 || board[x + 1][y + 1] != 'o')) {
                    board[x][y] = 'x';
                    board[x + 1][y] = 'x';
                    placed += 2;
                    x += 2;
                } else {
                    isRow = true;
                    x = rand.nextInt(5);
                    y = rand.nextInt(5);
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '.';
            }
        }

        board = placeZeroes(board);
        board = placeConnectedX(board);

        // Print the board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
