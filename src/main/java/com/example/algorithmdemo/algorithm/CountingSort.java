package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * @Author: wzp
 * @Date: 2020/2/20 14:42
 * @Version: 1.0
 */
public class CountingSort {


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
        int[] resultArray = countingSort(array);

        System.out.println("------------------");
        display(resultArray);
    }
    /**
     * 计数算法
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array){
        if (array.length == 0) return array;
        int bias,min = array[0],max = array[0];
        for (int i = 1;i < array.length;i++){
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket,0);
        for (int i = 0;i < array.length;i++){
            bucket[array[i] + bias]++;
        }
        int index = 0,i = 0;
        while (index < array.length){
            if (bucket[i] != 0){
                array[index] = i - bias;
                bucket[i]--;
                index++;
            }else {
                i++;
            }
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
