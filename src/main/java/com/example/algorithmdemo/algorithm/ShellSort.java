package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @description:
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @Author: wzp
 * @Date: 2020/2/19 11:37
 * @Version: 1.0
 */
public class ShellSort {

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
        int[] resultArray = shellSort(array);

        System.out.println("------------------");
        display(resultArray);
    }
    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array){
        if(array.length == 0){
            return array;
        }
        int len = array.length;
        int temp, gap = len/2;
        while(gap > 0){
            for (int i = gap;i < len; i++){
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
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
