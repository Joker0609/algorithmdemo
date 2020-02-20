package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @description:
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 * @Author: wzp
 * @Date: 2020/2/16 11:57
 * @Version: 1.0
 */
public class MaoPaoSort {

    public static final Logger log = LoggerFactory.getLogger(MaoPaoSort.class);
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
        int[] resultArray = bubbleSort(array);

        System.out.println("------------------");
        display(resultArray);
    }

    /**
     * 冒泡排序代码实现
     * @param array 排序数组
     * @return
     */
    public static int[] bubbleSort(int[] array){
        int temp;
        if(array.length == 0){
            return array;
        }
        for(int i = 0;i < array.length;i++){
            for (int j = 0;j < array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
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
