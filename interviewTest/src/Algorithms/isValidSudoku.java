package Algorithms;

/*LeetCode 36. 有效的数独*/
/*判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

        数字1-9在每一行只能出现一次。
        数字1-9在每一列只能出现一次。
        数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。


        上图是一个部分填充的有效的数独。

        数独部分空格内已填入了数字，空白格用'.'表示。

        示例1:

        输入:
        [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
        ]
        输出: true
        示例2:

        输入:
        [
         ["8","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]
        ]
        输出: false
        解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
        但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
        说明:

        一个有效的数独（部分已被填充）不一定是可解的。
        只需要根据以上规则，验证已经填入的数字是否有效即可。
        给定数独序列只包含数字1-9和字符'.'。
        给定数独永远是9x9形式的。*/


public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        boolean[][] row = new boolean[size][size];
        boolean[][] col = new boolean[size][size];
        boolean[][] box = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != '.'){
                    int tem = board[i][j] - '1';
                    int boxes = (i / 3) * 3 + j / 3;
                    if(row[i][tem] || col[j][tem] || box[boxes][tem]){
                        return false;
                    }
                    row[i][tem] = true;
                    col[j][tem] = true;
                    box[boxes][tem] = true;
                }
            }
        }

        return true;
    }
}
