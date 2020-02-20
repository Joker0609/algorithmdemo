package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @description:
 * 初始状态：无序区为R[1..n]，有序区为空；
 * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * n-1趟结束，数组有序化了。
 * @Author: wzp
 * @Date: 2020/2/19 10:15
 * @Version: 1.0
 */
public class SelectionSort {

    private static final Logger log = LoggerFactory.getLogger(SelectionSort.class);

    public static void main(String[] args){
        System.out.println("请输入数组大小");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        for (int i = 0;i < array.length;i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("==================");
        display(array);
        System.out.println();
        System.out.println("==================");
        int[] resultArray = selectSort(array);

        System.out.println("------------------");
        display(resultArray);
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        if (array.length == 0){
            return array;
        }
        for(int i = 0;i <array.length;i++){
            int minIndex = i;
            // 找到最小的数；在这个遍历过程中，会找到最小的数，然后将最小的数索引存下来
            for (int j = i; j< array.length;j++){
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            //在这里将最小的数放置第一位，第二次的时候就放在第二位，一次类推
            int temp = array[minIndex];
            array[minIndex]=array[i];
            array[i] = temp;
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
