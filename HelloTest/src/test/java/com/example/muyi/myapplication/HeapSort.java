package com.example.muyi.myapplication;

/**
 * Created by T530 on 2017/5/10.
 */

public class HeapSort {

    private static int heapSize;

    private static int LEFT(int i) {
        //returns left index of a zero index based array
        return 2 * i + 1;
    }

    private static int RIGHT(int i) {
        //returns right index of a zero based array
        return 2 * i + 2;
    }

    private static void BUILD_MAX_HEAP(int A[]) {
        heapSize = A.length;//heap size initialised
        for (int i = heapSize / 2 - 1; i >= 0; i--)//since n/2, n/2+1 ... are leaves we can start from n/2 step downwards
        {
            //call MAX_HEAPIFY on each root node starting from n/2
            MAX_HEAPIFY(A, i);
        }
    }

    private static void MAX_HEAPIFY(int A[], int i) {
        int l = LEFT(i);//the left element's index which is 2*i+1 (for zero based indexed array)
        int r = RIGHT(i);//right index = 2*i+2;
        int largestElementIndex = -1;
        if (l < heapSize && A[l] > A[i]) {
            largestElementIndex = l;
        } else {
            largestElementIndex = i;
        }

        if (r < heapSize && A[r] > A[largestElementIndex]) {
            largestElementIndex = r;
        }
        //if root doesn't has the largest index then swap the largest element with root element

        if (largestElementIndex != i) {
            int temp = A[i];
            A[i] = A[largestElementIndex];
            A[largestElementIndex] = temp;
            //after swap, recursively call the MAX_HEAPIFY on the largest index(root element)
            MAX_HEAPIFY(A, largestElementIndex);
        }
    }

    public static void HEAP_SORT(int A[]) {
        //max heap is built with heapSize initialised
        BUILD_MAX_HEAP(A);
        //starting from end loop through entire array
        for (int i = A.length - 1; i >= 0; i--) {
            //since heap is already heapified and maintains max heap property
            //the first element of the array is root of max heap
            //swap it with the extreme element of the array i.e. setting the largest element to the end of array
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            //reduce the heap window by 1
            heapSize = heapSize - 1;
            //call max heapify on the reduced heap
            MAX_HEAPIFY(A, 0);
        }
    }


}
