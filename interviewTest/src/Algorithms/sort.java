package Algorithms;

public class sort {
    //冒泡排序
    //两两挨个比较
    public static int[] bubbleSort(int[] sourceArray){
        for (int i = 1; i < sourceArray.length; i++){
            for (int j = 0; j < sourceArray.length - i; j++){
                if (sourceArray[j] > sourceArray[j + 1]){
                    int tmp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = tmp;
                }
            }
        }
        return sourceArray;
    }

    //选择排序
    //遍历一边寻找最小的，再遍历再找. 一共经历n - 1轮
    public static int[] selectionSort(int[] nums){
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

        return nums;
    }

    //插入排序
    /*将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
    从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。*/
    public static int[] insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            int j = i;
            while (j > 0 && tmp < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }

            if (j != i){
                nums[j] = tmp;
            }
        }

        return nums;
    }

    //快排
    public int[] sort(int[] arr){

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
