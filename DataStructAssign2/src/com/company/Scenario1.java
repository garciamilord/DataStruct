package com.company;

import java.io.File;
import java.util.Scanner;

public class Scenario1  {
    private static final int CUTOFF = 10;


    public static void main(String[] args) {
        // you need to store the read me in array
        //and you need readFiles object containing the file path
        double[] a= readFiles("uniformlyDistributedFrom-12BTo+12B.csv");

int num[]={100,1000,4000,16000,32000,64000,128000,256000,512000};
        System.out.println("pivot 1");
        for(int n: num){
            long start1 = System.nanoTime();
            quicksort(a,0,n-1);
            long end1 = System.nanoTime();
            long whole1 = end1 - start1;
            System.out.println(n+", "+/*a[n]*+*/"= "+whole1);
        }

        System.out.println(" Median : "+pivotPick(a,0,511999));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("pivot 2");

        for(int n: num) {

            long start2 = System.nanoTime();
            quicksort2(a, 0, n - 1);
            long end2 = System.nanoTime();
            long whole2 = end2 - start2;
            System.out.println(n + ", " + whole2);
        }
        System.out.println(" Median : "+pivotPick2(a,0,511999));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("pivot 3");
        for(int n: num){
            long start3 = System.nanoTime();
            quicksort3(a,0,n-1);
            long end3 = System.nanoTime();
            long whole3 = end3 - start3;
            System.out.println(n + ", " + whole3);

        }

        System.out.println(" Median : "+pivotPick3(a,0,511999));
        System.out.println("-----------------------------------------------------------------");


        System.out.println("pivot 4");
        for(int n: num){
            long start4 = System.nanoTime();
            quicksort4(a,0,n-1);
            long end4 = System.nanoTime();
            long whole4 = end4 - start4;
            System.out.println(n+", "+whole4);
        }

        System.out.println(" Median : "+pivotPick4(a,0,511999));
        System.out.println("-----------------------------------------------------------------");


    }
// read me file is need to run this function in the main
    private static double[] readFiles(String file) {
        try {
    File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while(s.hasNextDouble()){
                ctr++;
                s.nextDouble();
            }
            double[] num = new double[ctr];
            Scanner s1=new Scanner(f);
            for(int i=0; i< num.length; i++)
                num[i]=s1.nextDouble();
            return num;
        }
        catch(Exception e){
return null;
        }
    }


    private static void quicksort(double[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            double pivot = pivotPick(a, left, right);

            // Begin partitioning
            int i = left - 1, j = right + 1;
            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            quicksort(a, left, i - 1); // Sort small elements
            quicksort(a, j + 1, right); // Sort large elements
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    private static void quicksort2(double[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            double pivot = pivotPick2(a, left, right);

            // Begin partitioning
            int i = left - 1, j = right + 1;
            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            quicksort(a, left, i - 1); // Sort small elements
            quicksort(a, j + 1, right); // Sort large elements
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    private static void quicksort3(double[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            double pivot = pivotPick3(a, left, right);

            // Begin partitioning
            int i = left - 1, j = right + 1;
            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            quicksort(a, left, i - 1); // Sort small elements
            quicksort(a, j + 1, right); // Sort large elements
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    private static void quicksort4(double[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            double pivot = pivotPick4(a, left, right);

            // Begin partitioning
            int i = left - 1, j = right + 1;
            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }
            quicksort(a, left, i - 1); // Sort small elements
            quicksort(a, j + 1, right); // Sort large elements
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    private static void swapReferences(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static double findMedianof5(double[] a) {
        if (a.length != 5)
            return Double.MIN_VALUE;
        if (a[0] < a[1])
            swapReferences(a, 0, 1);
        if (a[2] < a[3])
            swapReferences(a, 2, 3);
        if (a[0] < a[2]) {
            swapReferences(a, 0, 2);
            swapReferences(a, 1, 3);
        }
        if (a[1] < a[4])
            swapReferences(a, 1, 4);
        if (a[1] > a[2])
            if (a[2] > a[4])
                return a[2];
            else
                return a[4];
        else if (a[1] > a[3])
            return a[1];
        else
            return a[3];
    }

    private static double pivotPick(double[] a, int left, int right) {

        double b = a[(right + left) / 2];
        return b;
    }

    private static double pivotPick2(double[] a, int left, int right) {
        double l = a[left];
        double r = a[right];
        double mid = a[(left + right) / 2];

        if ((l < mid) && (mid < r)) {

        } else if ((l > mid) && (l < r)) {
            swapReferences(a, 4, 0);

        } else if ((l < r) && (r < mid)) {
            swapReferences(a, 4, 8);
        }
        return mid;


    }

    private static double pivotPick3(double[] a, int left, int right) {
        double l = a[left];
        double r = a[right];
        double mid = a[(left + right) / 2];
        double lmid = a[((3 * left) + right) / 4];
        double rmid = a[(left + (3 * right)) / 4];

        return findMedianof5(new double[] {l,r,mid,lmid,rmid});

    }

    private static double pivotPick4(double[] a, int left, int right) {
        double Mu = -12000000000d + ((left + right) / (2 * (a.length - 1)) * (24000000000d));
        return findMedianof5(new double[]{Mu, a[left], a[right],
                a[((2 * left) + right) / 3], a[(left + (2 * right)) / 3]});


    }

    public static void insertionSort(double[] a, int left, int right) {

            for (int i = left + 1; i <= right; i++) {
                double tmp = a[i];
                int j;

                for (j = i; j > left && tmp < 0; j--)
                    a[j] = a[j - 1];
                a[j] = tmp;
        }

    }
}