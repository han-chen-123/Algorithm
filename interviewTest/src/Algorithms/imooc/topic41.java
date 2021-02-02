package Algorithms.imooc;

/*349. 两个数组的交集
        给定两个数组，编写一个函数来计算它们的交集。



        示例 1：

        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
        示例 2：

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]


        说明：

        输出结果中的每个元素一定是唯一的。
        我们可以不考虑输出结果的顺序。*/

import java.util.*;

public class topic41 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();

        for (int i = 0; i < nums1.length; i++){
            record.add(nums1[i]);
        }

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++){
            if (record.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }

        int[] result = new int[res.size()];
        int k = 0;
        for (Integer i : res){
            result[k++] = i;
        }

        return result;
    }


    //350
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else {
                map.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> record = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                record.add(nums2[i]);
                map.put(nums2[i] , map.get(nums2[i]) - 1);
            }
        }

        int index = 0;
        int[] res = new int[record.size()];
        for(Integer k : record){
            res[index++] = k;
        }

        return res;
    }

    //290
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] sWords = s.split(" ");
        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(sWords[i])){
                    return false;
                }
            }else{
                if (set.contains(sWords[i])){
                    return false;
                }
                map.put(c, sWords[i]);
                set.add(sWords[i]);
            }
        }
        return true;
    }

    //242
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(cs[i])){
                map.put(cs[i], map.get(cs[i]) + 1);
            }else {
                map.put(cs[i], 1);
            }
        }

        for (int i = 0; i < t.length(); i++){
            if (map.containsKey(ct[i])){
                map.put(ct[i], map.get(ct[i]) - 1);
            }else{
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
            record[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (record[i] != 0){
                return false;
            }
        }
        return true;
    }

    //205
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        if (s.length() != t.length()){
            return false;
        }

        char[] sc = s.toCharArray();
        char[] tc = s.toCharArray();
        for (int i = 0; i < sc.length; i++){
            if (map.containsKey(sc[i])){
                if (!map.get(sc[i]).equals(tc[i])){
                    return false;
                }
            }else{
                if (set.contains(tc[i])){
                    return false;
                }
                set.add(tc[i]);
                map.put(sc[i], tc[i]);
            }
        }

        return true;
    }

    /*451. 根据字符出现频率排序
    给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

    示例 1:

    输入:
            "tree"

    输出:
            "eert"

    解释:
            'e'出现两次，'r'和't'都只出现一次。
    因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
    示例 2:

    输入:
            "cccaaa"

    输出:
            "cccaaa"

    解释:
            'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
    注意"cacaca"是不正确的，因为相同的字母必须放在一起。
    示例 3:

    输入:
            "Aabb"

    输出:
            "bbAa"

    解释:
    此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
    注意'A'和'a'被认为是两种不同的字符。*/

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(c[i])){
                map.put(c[i], map.get(c[i]) + 1);
            }else{
                map.put(c[i], 1);
            }
        }

        //第二部分：装桶
        List<Character>[]list = new List[s.length()+1];
        //装桶就是遍历所有key值装进去
        for(char key: map.keySet()){
            //通过key值返回找到频率赋给i
            int i = map.get(key);
            //i值是索引，代表出现的次数
            if(list[i]==null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        //第三部分，拆桶倒序输出
        char[] res = new char[s.length()];
        int index = 0;
        for(int i = list.length-1; i>0; i--){
            if(list[i]==null)continue;
            //遍历所有需要输出的list[i]
            for(char p: list[i]){
                for(int j=0;j<i;j++){
                    res[index++]=p;
                }
            }
        }
        return new String(res);
    }
}
