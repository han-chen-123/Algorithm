package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class sort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 65, 23, 100, 12, 34, 6, 77, 43};
        heapsort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    //冒泡排序
    //两两挨个比较
    public static void bubbleSort(int[] sourceArray){
        for (int i = 1; i < sourceArray.length; i++){
            for (int j = 0; j < sourceArray.length - i; j++){
                if (sourceArray[j] > sourceArray[j + 1]){
                    int tmp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = tmp;
                }
            }
        }
    }

    //选择排序
    //遍历一边寻找最小的，再遍历再找. 一共经历n - 1轮
    public static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }

            if (i != min){
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }

    //插入排序
    /*将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
    从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。*/
    public static void insertSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j > 0; j--){
                if (nums[j] < nums[j - 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }else{
                    break;
                }
            }
        }
    }

    //希尔 递减增量排序
    //根据增量的不同 分段的实现插入排序
    public static void shellSort(int[] arr){
        //knurth序列
        int h = 1;
        while (h <= arr.length / 3){
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        int tmp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = tmp;
                    }
                }
            }
        }
    }

    //归并
    public static void mergeSort(int[] arr, int left, int right){
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr - 1;
        int[] tmp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound){
            if (arr[i] <= arr[j]){
                tmp[k] = arr[i];
                i++;
                k++;
            }else{
                tmp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= rightBound) tmp[k++] = arr[j++];

        for (int m = 0; m < tmp.length; m++) arr[leftPtr + m] = tmp[m];
    }

    //快排
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) return;
        int base = arr[left];
        int i = left;
        int j = right;

        while (i != j){
            while (arr[j] >= base && i < j){
                j--;
            }

            while (arr[i] <= base && i < j){
                i++;
            }

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    //堆排序
    public static void heapsort(int[] arr){
        int tmp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--){
            tmp = arr[j];
            arr[j] = arr[0];
            arr[0] = tmp;
            heapAdjust(arr, 0, j);
        }
    }

    /**
     * 调整为大顶堆
     * @param arr
     * @param i 非叶子节点的index
     * @param length 长度
     */
    public static void heapAdjust(int[] arr, int i, int length){
        int tmp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            //比较左右节点, 改k的指向
            if (k + 1< length && arr[k] < arr[k + 1]){
                k++;
            }
            //比较子节点是否比父节点大，如果大则交换
            if (arr[k] > tmp){
                arr[i] = arr[k];
                i = k; //i指向k，继续循环比较
            }else {
                break;
            }
            arr[i] = tmp;
        }
    }

    //桶排序
    public static double[] bucketSort(double[] arr){
        //1.计算出最大值和最小值，求出两者的差值
        double min = arr[0];
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        double d = max - min;

        //2.初始化桶
        int bucketNum = arr.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //3.遍历数组中的元素，把所有元素都放入对应的桶当中
        for (int i = 0; i < arr.length; i++) {
            //计算当前元素应该放在哪个桶里面
            int num = (int)((arr[i] - min) / (d / (bucketNum - 1)));
            bucketList.get(num).add(arr[i]);
        }

        //4.对每个桶里面的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        int k = 0;
        for(LinkedList<Double> doubles : bucketList){
            for (Double aDouble : doubles) {
                arr[k] = aDouble;
                k++;
            }
        }

        return arr;
    }

    //基数排序

}
