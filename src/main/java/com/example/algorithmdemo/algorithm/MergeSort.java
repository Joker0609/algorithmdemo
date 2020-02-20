package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 * @Author: wzp
 * @Date: 2020/2/20 10:34
 * @Version: 1.0
 */
public class MergeSort {

    private static final Logger log = LoggerFactory.getLogger(SelectionSort.class);

    public static void main(String[] args){
        System.out.println("请输入数组大小");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        System.out.println("请输入排序数组");
        for (int i = 0;i < array.length;i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("==================");
        display(array);
        System.out.println();
        System.out.println("==================");
        int[] resultArray = mergeSort(array);

        System.out.println("------------------");
        display(resultArray);
    }
    /**
     * 归并排序
     * @param array 需要排序数组
     * @return 返回排序后的数组
     */
    public static int[] mergeSort(int[] array){
        if (array.length < 2){
            return array;
        }
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 归并排序---将两段排序好的数组合成一个排序数组
     * @param left 将数组分为的左侧数组
     * @param right 将数组分为的右侧数组
     * @return 返回排序后的数组
     */
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index = 0,i = 0,j = 0;index < result.length;index++){
            if (i >= left.length){
                result[index] = right[j++];
            }else if(j >= right.length){
                result[index] = left[i++];
            }else if(left[i] > right[j]){
                result[index] = right[j++];
            }else{
                result[index] = left[i++];
            }
        }
        return result;
    }
    /**
     * 展示
     * @param array
     */
    public static void display(int[] array){
        for (int i = 0; i < array.length;i++){
            System.out.print(array[i]+"\t");
        }
    }
}
