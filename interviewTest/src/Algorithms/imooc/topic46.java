package Algorithms.imooc;

/*447. 回旋镖的数量
        给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

        返回平面上所有回旋镖的数量。


        示例 1：

        输入：points = [[0,0],[1,0],[2,0]]
        输出：2
        解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
        示例 2：

        输入：points = [[1,1],[2,2],[3,3]]
        输出：2
        示例 3：

        输入：points = [[1,1]]
        输出：0


        提示：

        n == points.length
        1 <= n <= 500
        points[i].length == 2
        -104 <= xi, yi <= 104
        所有点都 互不相同*/

import java.util.HashMap;
import java.util.Map;

public class topic46 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++){
                if (j != i){
                    int dis = disCal(points[i], points[j]);
                    if (map.containsKey(dis)){
                        map.put(dis, map.get(dis) + 1);
                    }else {
                        map.put(dis, 1);
                    }
                }
            }
            for (Integer dis : map.keySet()){
                res += map.get(dis) * (map.get(dis) - 1);
            }
        }

        return res;
    }

    public int disCal(int[] x, int[] y){
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }


   /* 149. 直线上最多的点数
    给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

    示例 1:

    输入: [[1,1],[2,2],[3,3]]
    输出: 3
    解释:
            ^
    |
    |        o
    |     o
    |  o
    +------------->
    0  1  2  3  4
    示例 2:

    输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    输出: 4
    解释:

    |
    |  o
    |     o        o
    |        o
    |  o        o
    +------------------->
    0  1  2  3  4  5  6*/

    /*public int maxPoints(int[][] points) {

    }*/
}
