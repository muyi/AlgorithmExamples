package com.example.muyi.myapplication;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by T530 on 2017/3/22.
 */

public class ExampleUnitTest3 {

    /**
     * @param nums
     */
    private void selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int count = 0;

        int length = nums.length;
        int min;
        int temp;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }

            }
            if (min != i) {//min不等于i，说明nums[i]不是最小的
                count++;
                temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
                System.out.print("第" + count + "次");
                for (int k = 0; k < length; k++) {

                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }

        }

    }

    @Test
    public void test1() {
        int[] nums = {8, 3, 7, 1, 0, 3, 9, 6, 4, 23, 5, 2};
        selectionSort(nums);
    }


    @Test
    public void test2() throws NoSuchMethodException {
        Class clazz = Singleton.class;

        Method[] methods = clazz.getMethods();
        int len = methods.length;

//        for (int i = 0; i <len ; i++) {
//            String  name =methods[i].getName();
//            System.out.println(name);
//        }

        int mod = clazz.getModifiers();
        System.out.print(Modifier.toString(mod));


    }

    @Test
    public void testSerializable() throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.INSTANCE;
        FileOutputStream fos = new FileOutputStream("obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singleton);
        oos.close();
        //
        FileInputStream fis = new FileInputStream("obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton singleton1 = (Singleton) ois.readObject();
        System.out.print(singleton1 == singleton);

    }

    private void insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && (temp < nums[j])) {
                nums[j + 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }


    private void shellSort(int[] nums) {
        int len = nums.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = 0; i < len - gap; i++) {
                int j = i + gap;
                int temp = nums[j];
                while (j >= gap && (temp < nums[j - gap])) {
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = temp;
            }
            gap = gap / 2;
        }
    }


    @Test
    public void testInsertionSort() {
        int[] nums = {8, 5, 2,0, 4, 7, 3, 6, 9, 1};
        // insertionSort(nums);
        // shellSort(nums);
        // HeapSort.HEAP_SORT(nums);
        MergeSort.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }


}
