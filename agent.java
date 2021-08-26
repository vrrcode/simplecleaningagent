
import java.util.concurrent.ThreadLocalRandom;

public class agent {
    static int costarr[] = new int[9];
    static int k = 0;

    static boolean isClean(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void clean(int board[][], int x, int y) {

        int cost = 0;
        while (!isClean(board)) {
            cost++;
            int i = ThreadLocalRandom.current().nextInt(0, board.length);
            int j = ThreadLocalRandom.current().nextInt(0, board.length);
            if (board[i][j] == 0) {
                suck(board, i, j);
            }
        }
        System.out.println(cost);
        costarr[k++] = cost;
    }

    static void suck(int board[][], int i, int j) {
        board[i][j] = 1;
    }

    static void avgcost() {
        int sum = 0;
        for (int i = 0; i < costarr.length; i++) {
            sum += costarr[i];
        }
        int avg = sum / 9;
        System.out.println("The average cost is: " + avg);
    }

    public static void main(String[] args) {

        int board[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                setarray(board);
                System.out.print("Cost from postion " + "(" + i + "," + j + ") is:");
                clean(board, i, j);
            }
        }
        avgcost();
    }

    private static void setarray(int board[][]) {
        int arr[][] = { { 0, 0, 0,0 }, { 0, 0, 0,0 }, { 0, 0, 0,0 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = arr[i][j];

            }

        }

    }

}