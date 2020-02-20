package com.example.algorithmdemo.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @description:
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，
 * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @Author: wzp
 * @Date: 2020/2/20 10:54
 * @Version: 1.0
 */
public class QuickSort {

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
        int[] resultArray = quickSort(array,0,5);
        System.out.println("==================");
        display(resultArray);
    }
    /**
     *  快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array,int start, int end){
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        int smallIndex = partition(array,start,end);
        if (smallIndex > start){
            quickSort(array,start,smallIndex-1);
        }
        if (smallIndex < end){
            quickSort(array,smallIndex+1,end);
        }
        return array;
    }

    /**
     * 快速排序算法--partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array,int start, int end){
        int pivot = (int) (start + Math.random() * (end - start +1));
        int smallIndex = start -1;
        swap(array,pivot,end);
        for (int i = start;i <= end;i++){
            if (array[i] <= array[end]){
                smallIndex++;
                if (i > smallIndex){
                    swap(array,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内的两个元素
     * @param array 数组
     * @param i 索引
     * @param j 索引
     */
    public static void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
