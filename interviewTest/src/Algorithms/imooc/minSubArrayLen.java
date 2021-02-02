package Algorithms.imooc;

/*209. 长度最小的子数组
        给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。



        示例：

        输入：s = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。


        进阶：

        如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (left < nums.length){
            if(sum < s && right + 1 < nums.length){
                right++;
                sum += nums[right];
            }else{
                sum -= nums[left];
                left++;
            }

            if (sum >= s){
                res = Math.min(res, right - left + 1);
            }
        }
        if (res == nums.length + 1){
            return 0;
        }
        return res;
    }


    //3
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;

        while(l < s.length()){
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0){
                r++;
                freq[s.charAt(r)]++;
            }else{
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    //438
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++){
            pFreq[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = -1;
        while (left < s.length()){
            if (left + 1 < s.length() && right - left + 1 < p.length()){
                right++;
            }else {
                left++;
            }

            if (right - left + 1 == p.length() && isAnagrams(s.substring(left, right + 1), pFreq)){
                res.add(left);
            }
        }

        return res;
    }

    public boolean isAnagrams(String window, int[] pFreq){
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++){
            windowFreq[window.charAt(i) - 'a']++;
        }

        for (int i = 0; i < windowFreq.length; i++){
            if (windowFreq[i] != pFreq[i]){
                return false;
            }
        }
        return true;
    }

}
