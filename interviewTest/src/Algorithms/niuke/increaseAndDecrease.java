package Algorithms.niuke;

/*题目描述
        计算最少出列多少位同学，使得剩下的同学排成合唱队形

        说明：

        N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
        合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。

        你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。


        注意不允许改变队列元素的先后顺序
        请注意处理多组输入输出！

        输入描述:
        整数N

        输出描述:
        最少需要几位同学出列*/

import java.util.*;
import java.util.Map.Entry;
public class increaseAndDecrease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++){
                nums[i] = sc.nextInt();
            }

            int[] left_queue = new int[num];
            int[] right_queue = new int[num];

            for (int i = 0; i < num; i++){
                left_queue[i] = 1;
                right_queue[i] = 1;
            }

            for (int i = 0; i < num; i++){
                for (int j = 0; j < i; j++){
                    if (nums[i] > nums[j] && left_queue[j] + 1 > left_queue[i] ){
                        left_queue[i]++;
                    }
                }
            }

            for (int i = num - 1; i > 0; i--){
                for (int j = num - 1; j > i; j--){
                    if (nums[i] > nums[j] && right_queue[j] + 1 > right_queue[i]){
                        right_queue[i]++;
                    }
                }
            }

            int max =0;
            for (int i = 0; i < num; i++){
                if (left_queue[i] + right_queue[i] > max){
                    max = left_queue[i] + right_queue[i];
                }
            }

            System.out.println(num - max + 1);
        }
    }
}
