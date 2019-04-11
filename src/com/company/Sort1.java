package com.company;


import java.util.Arrays;


public class Sort1 {

    public int[] bubleSort(int[] arr) {
        int length = arr.length;
        int index, innerIndex, flag = 0;
        for(index = 0; index < length; index++) {
            if(index != 0 && flag == 0) {
                return arr;
            }
            for(innerIndex = 0; innerIndex < length - index - 1; innerIndex ++) {
                if(arr[innerIndex] > arr[innerIndex + 1]) {
                    int temp = arr[innerIndex+1];
                    arr[innerIndex+1] = arr[innerIndex];
                    arr[innerIndex] = temp;
                    flag = 1;
                }
            }
        }
        return arr;
    }

    /*
    * 归并排序主要的使用在于层层分割分成了单个，然后每一次传入的left right都不同所以每一次逐步比较之后合并
    *
    *
    *
    * */



    public void guibingSort(int left, int right, int [] arr) {
       if(left == right) {
           return;
       }
       int mid = (left + right) / 2;
        guibingSort(left, mid, arr);
        guibingSort(mid + 1, right, arr);
        mergeSort(left, right, mid, arr);

    }

    public void mergeSort(int left, int right, int mid, int [] arr) {
        int [] leftArr = new int[mid - left];
        int [] rightArr = new int[right - mid + 1];
        int i, j;
        for(i = left; i < mid; i++) {
            leftArr[i-left] = arr[i];
        }
        for(j = mid; j <= right; j++) {
            rightArr[j - mid] = arr[j];
        }
        i = 0;
        j = 0;
        int k = left;
        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            }else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
        while(j < rightArr.length) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
        while(i < leftArr.length) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
    }

    public void quickSort(int [] arr, int left, int right) {
        if(left < right) {
            int temp = Sort(arr, left, right);
            quickSort(arr, left, temp - 1);
            quickSort(arr, temp + 1, right);
        }

    }

    /*
    * 利用递归从数组最右边开始比较只要比基准大就左边移动否则控制权交给右边同理左边一只小的话就加下去否则进行换位和控制权转移
    * */

    public int Sort(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= temp) {
                right--;
            }
            if(left < right) {
                arr[left++] = arr[right];
             }
            while(left < right && arr[left] <= temp) {
                left++;
            }
            if(left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;
        System.out.println("kaishi");
        System.out.println(Arrays.toString(arr));
        System.out.println("kaishi");
        return left;
    }

    /*
    * 选择排序主要是每次选出选出最小的和当前的最外层的交换位置保证每次都是小的放在前面
    * */
    public void ChangeSort(int [] arr) {
        int min, temp;
        for (int i = 0; i < arr.length; i++) {
            // 初始化未排序序列中最小数据数组下标
            min = i;

            for (int j = i+1; j < arr.length; j++) {
                // 在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 将未排序列中最小元素放到已排序列末尾
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /*
    *
    * 希尔排序
    *
    * */
    public void shellSort(int [] arr) {
        int len  = arr.length;
        int intervalLength = len / 3;
        while(intervalLength > 0) {
            for(int  i = intervalLength; i < len; i ++ ) {
                int j = i;
                int target=arr[i];
                // 这里其实很浪费性能相当于市进行一轮比较隔着几个的进行比较然后交换位置很低效，数目的累积就会重新回朔一边回到最0的位置
                while(j >= intervalLength && target < arr[j - intervalLength]) {
                    arr[j] = arr[j-intervalLength];
                    j-=intervalLength;
                }
                arr[j]=target;

            }
            System.out.println(Arrays.toString(arr));
            intervalLength = intervalLength / 3 ;
        }

    }

        /*
        *
        *   堆排序
        *   1、建立堆
        *   2、进行堆排序
        *
        */

    public void duiSort(int [] arr) {

    }

    public void buildDui(int [] arr) {

    }




    public static void main(String[] args) {
        Sort1 s = new Sort1();
        int[] arr= {72,6,57,88,60,42,83,73,48,85, 9};
//        s.bubleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        s.ChangeSort(arr);
//        s.guibingSort(0, arr.length - 1, arr);
        s.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
