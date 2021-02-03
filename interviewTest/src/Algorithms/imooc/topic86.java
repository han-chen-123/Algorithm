package Algorithms.imooc;

/*79. 单词搜索
        给定一个二维网格和一个单词，找出该单词是否存在于网格中。

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

public class topic86 {
    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (existHelper(board, word, 0, i, j, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean existHelper(char[][] board, String word, int index, int startX, int startY, boolean[][] visited){
        if (index == word.length() - 1){
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + dir[i][0];
                int newY = startY + dir[i][1];
                if (newX < board.length && newY < board[0].length && newX >= 0 && newY >= 0
                        && !visited[newX][newY]) {
                    if (existHelper(board, word, index + 1, newX, newY, visited)) {
                        return true;
                    }
                }
            }

            //没有找到就回溯
            visited[startX][startY] = false;
        }

        return false;
    }
}
