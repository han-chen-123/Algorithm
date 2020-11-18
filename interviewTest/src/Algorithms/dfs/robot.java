package Algorithms.dfs;

import java.util.*;

public class robot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int row = sc.nextInt();
            int column = sc.nextInt();
            int[][] grid = new int[row][column];

            for (int i = 0; i < row; i++ ){
                for (int j = 0; j < column; j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            List<List<Integer>> ansList = new ArrayList<>();
            dfs(grid, 0, 0, new boolean[row][column], ansList, row, column);
            for (List<Integer> list : ansList){
                System.out.println(list);
            }
        }
    }

    public static boolean dfs(int[][] grid, int row, int column, boolean[][] visited, List<List<Integer>> pathList, int n, int m){
        if (row >= m || column >= n || grid[row][column] == 1 || visited[row][column]){
            return false;
        }

        pathList.add(Arrays.asList(row,column));
        if (row == m - 1 && column == n - 1){
            return true;
        }

        visited[row][column] = true;
        if (dfs(grid, row + 1, column, visited, pathList, n, m) || dfs(grid, row, column + 1, visited, pathList, n, m)){
            return true;
        }

        pathList.remove(pathList.size() - 1);
        return false;
    }
}

