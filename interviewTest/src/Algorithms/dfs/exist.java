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
    public boolean[][] visited;
    public String word;
    public char[][] board;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        if(word.length() == 0){
            return true;
        }
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (dfs(i, j, 0)== true){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int idx){
        if (idx == word.length()){
            return true;
        }
        if (i < 0 || i >=board.length || j < 0 || j >= board[0].length || visited[i][j] == true || board[i][j] != word.charAt(idx)){
            return false;
        }else{
            visited[i][j] = true;
        }

        boolean res = dfs(i - 1, j, idx + 1) || dfs(i + 1, j, idx + 1) || dfs(i, j - 1, idx + 1) || dfs(i, j + 1, idx + 1);
        visited[i][j] = false;

        return res;
    }
}
