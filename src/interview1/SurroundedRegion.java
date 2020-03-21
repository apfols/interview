package interview1;

import java.util.*;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegion {
    /**
     * Solution 1: traverse every nodes. If the connected graph does not touch border, flip it.
     *
     * time: O(n)
     */
//    public void solve(char[][] board) {
//        if (board.length < 3 || board[0].length < 3)
//            return;
//
//        int height = board.length;
//        int width = board[0].length;
//
//        boolean[][] occupied = new boolean[height][];
//        for (int i = 0; i < height; i++)
//            occupied[i] = new boolean[width];
//
//        for (int i = 1; i < height - 1; i++) {
//            for (int j = 1; j < width - 1; j++) {
//                if (board[i][j] == 'X' || occupied[i][j])
//                    continue;
//
//                traverse(height, width, board, occupied, i, j);
//            }
//        }
//    }
//
//    public void traverse(int height, int width, char[][] board, boolean[][] occupied, int y, int x) {
//        boolean surrounded = true;
//        ArrayList<Pair<Integer, Integer>> traversed = new ArrayList<>();
//        Queue<Pair<Integer, Integer>> walk = new LinkedList<>();
//        walk.add(new Pair<>(x, y));
//
//        //traverse
//        while (!walk.isEmpty()) {
//            Pair<Integer, Integer> pair = walk.remove();
//            traversed.add(pair);
//
//            int walkX = pair.getKey();
//            int walkY = pair.getValue();
//
//            if (walkX == 0 || walkY == 0 || walkX == width - 1 || walkY == height - 1) {
//                surrounded = false;
//                continue;
//            }
//
//            if (walkX > 0 && !occupied[walkY][walkX - 1] && board[walkY][walkX - 1] == 'O') {
//                walk.add(new Pair<>(walkX - 1, walkY));
//                occupied[walkY][walkX - 1] = true;
//            }
//
//            if (walkX < width - 1 && !occupied[walkY][walkX + 1] && board[walkY][walkX + 1] == 'O') {
//                walk.add(new Pair<>(walkX + 1, walkY));
//                occupied[walkY][walkX + 1] = true;
//            }
//
//            if (walkY > 0 && !occupied[walkY - 1][walkX] && board[walkY - 1][walkX] == 'O') {
//                walk.add(new Pair<>(walkX, walkY - 1));
//                occupied[walkY - 1][walkX] = true;
//            }
//
//            if (walkY < height - 1 && !occupied[walkY + 1][walkX] && board[walkY + 1][walkX] == 'O') {
//                walk.add(new Pair<>(walkX, walkY + 1));
//                occupied[walkY + 1][walkX] = true;
//            }
//        }
//
//        //flipping if surrounded
//        if (surrounded) {
//            for (Pair<Integer, Integer> each: traversed)
//                board[each.getValue()][each.getKey()] = 'X';
//        }
//    }

    /**
     * Solution 2:
     * - traverse all connected graph of border nodes and set it to '*'
     * - convert 'O' -> 'X', '*' -> 'O'
     *
     * time: O(n)
     */
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3)
            return;

        // traverse boarder connected graph and flip it to '*'
        for (int y: new int[] {0, board.length - 1}) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'O')
                    traverse(board, y, x);
            }
        }

        for (int x: new int[] {0, board[0].length - 1}) {
            for (int y = 0; y < board.length; y++) {
                if (board[y][x] == 'O')
                    traverse(board, y, x);
            }
        }

        // flip 'O' -> 'X', '*' -> 'O'
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == '*')
                    board[y][x] = 'O';
                else if (board[y][x] == 'O')
                    board[y][x] = 'X';
            }
        }
    }

    private void traverse(char[][] board, int y, int x) {
        int height = board.length;
        int width = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        board[y][x] = '*';
        queue.add(new int[] {y, x});

        while (!queue.isEmpty()) {
            int[] coords = queue.remove();
            int coordY = coords[0];
            int coordX = coords[1];

            // up
            if (coordY > 0 && board[coordY - 1][coordX] == 'O') {
                queue.add(new int[] {coordY - 1, coordX});
                board[coordY - 1][coordX] = '*';
            }


            // down
            if (coordY < height - 1 && board[coordY + 1][coordX] == 'O') {
                queue.add(new int[] {coordY + 1, coordX});
                board[coordY + 1][coordX] = '*';
            }


            // left
            if (coordX > 0 && board[coordY][coordX - 1] == 'O') {
                queue.add(new int[] {coordY, coordX - 1});
                board[coordY][coordX - 1] = '*';
            }


            // right
            if (coordX < width - 1 && board[coordY][coordX + 1] == 'O') {
                queue.add(new int[] {coordY, coordX + 1});
                board[coordY][coordX + 1] = '*';
            }

        }
    }

    private static void check(char[][] board) {
        SurroundedRegion r = new SurroundedRegion();
        r.solve(board);
        System.out.println("[");
        for (int i = 0; i < board.length; i++)
            System.out.println("  " + Arrays.toString(board[i]));
        System.out.println("]");
    }


    public static void main(String[] args) {
        check(new char[][] {
                new char[] {'X', 'X', 'X', 'X'},
                new char[] {'X', 'O', 'O', 'X'},
                new char[] {'X', 'X', 'O', 'X'},
                new char[] {'X', 'O', 'X', 'X'},
        });

        check(new char[][] {
                new char[] {'X', 'X', 'X', 'X'},
                new char[] {'X', 'X', 'O', 'X'},
                new char[] {'X', 'X', 'X', 'X'},
                new char[] {'X', 'X', 'O', 'X'},
                new char[] {'X', 'O', 'O', 'X'},
        });

        check(new char[][]{
                new char[]{'X', 'O', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
        });

    }
}
