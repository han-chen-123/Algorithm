package Algorithms.dfs;

/*给定一个二维网格和一个单词，找出该单词是否存在于网格中。

        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

        示例:

        board =
        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]

        给定 word = "ABCCED", 返回 true
        给定 word = "SEE", 返回 true
        给定 word = "ABCB", 返回 false*/

public class exist {
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backtrack(i, j, board, word, visited, 0);
            }
        }
        return find;
    }

    public void backtrack(int i, int j, char[][] board, String word, boolean[][] visited, int pos){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)){
            return;
        }

        if(pos == word.length() - 1){
            find = true;
            return;
        }

        visited[i][j] = true;
        backtrack(i + 1, j, board, word, visited, pos + 1);
        backtrack(i, j + 1, board, word, visited, pos + 1);
        backtrack(i - 1, j, board, word, visited, pos + 1);
        backtrack(i, j - 1, board, word, visited, pos + 1);
        visited[i][j] = false;
    }


}
