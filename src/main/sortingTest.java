package main;

import java.util.*;

public class sortingTest
{
    // Simple performance comparison of sorting algorithms

    public static void main(String args[])
    {
        int A[];
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        while(true){
            //Filling array with n random numbers, n provided by user.
            System.out.print("Amount of numbers to sort?: ");
            int n = Integer.parseInt(in.nextLine());
            A = new int[n];

            for (int i = 0; i < n; i++)
                A[i] = r.nextInt(n);

            //Menu for choosing algorithm
            System.out.println("Sorting method to use (1-4): ");
            System.out.println("1. Insertion sort");
            System.out.println("2. Quick sort");
            System.out.println("3. Merge sort");
            System.out.println("4. Radix sort");
            int method = Integer.parseInt(in.nextLine());

            //Choosing operation
            System.out.println("Choose test (1/2): ");
            System.out.println("1. Sorting");
            System.out.println("2. Constant estimate");
            int operation = Integer.parseInt(in.nextLine());

            //Timing sort
            long time = System.currentTimeMillis();
            sort(A, method, n);
            time = System.currentTimeMillis() - time;

            if(operation == 1){
                System.out.printf("Numbers sorted in\t: %6.3f s\n", time/1000.0);
            }
            else if(operation == 2){
                System.out.println("Constant: C = "+findConstant(method,n,time));
            }

            System.out.print("Press q to quit or any key to restart: ");
            String op = in.nextLine();
            if(op.equals("q"))
                break;
        }
    }

    private static float findConstant(int method, int n, long T) {
        if(method == 1){
            return (float)T/(n*n);
        }
        else if(method == 2 || method == 3){
            return (float) (T/(n * Math.log(n)));
        }
        else if(method == 4){
            return (float)T/n;
        }
        else{
            System.out.println("Invalid method selected");
            return 0;
        }
    }

    private static void sort(int A[], int algorithm, int n){
        switch (algorithm){
            case 1: sequentialSorting.insertionSort(A);
                break;
            case 2: logarithmicSorting.quickSort(A, 0, n-1);
                break;
            case 3: logarithmicSorting.mergeSort(A, 0, n-1);
                break;
            case 4: radixSorting.radixSort(A, (int)(Math.log10(n)+1));
                break;
            default: System.out.println("Invalid menu option");
                break;
        }
    }
}