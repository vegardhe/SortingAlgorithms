package main;

import jsjf.CircularArrayQueue;

public class radixSorting {

    public static void radixSort(int A[], int maxDigits){

        int weight = 1;
        int n = A.length;

        CircularArrayQueue<Integer>[] Q =
                (CircularArrayQueue<Integer>[])(new CircularArrayQueue[10]);

        for (int i = 0; i < 10; i++)
            Q[i] = new CircularArrayQueue<>();

        for (int m = 0; m < maxDigits; m++)
        {
            for (int i = 0; i < n; i++)
            {
                int digit = (A[i] / weight) % 10;
                Q[digit].enqueue(A[i]);
            }
            int j = 0;
            for (int i = 0; i < 10; i++)
                while (!Q[i].isEmpty())
                    A[j++] = Q[i].dequeue();

            weight *= 10;
        }
    }

}
