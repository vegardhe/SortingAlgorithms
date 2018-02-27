package main;

public class sequentialSorting
{
    public static void insertionSort(int A[])
    {
        int n = A.length;
        int key;

        for (int i = 1; i < n; i++)
        {
            key = A[i];
            int j = i;

            while (j > 0 && A[j-1] > key)
            {
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }
}