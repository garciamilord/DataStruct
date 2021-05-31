package com.company;

import java.io.File;
import java.util.Scanner;

public class Bonus {
    private static final int CUTOFF = 10;

    public static void main(String[] args) {
        // you need to store the read me in array
        //and you need readFiles object containing the file path
        double[] a = readFiles("quantile.csv");
        System.out.println("Bonus 1");

        int num[] = {100, 1000, 4000, 16000, 32000, 64000, 128000, 256000, 512000};

        for (int n : num) {
            long start1 = System.nanoTime();
            quicksortStat(a, 0, n - 1);
            long end1 = System.nanoTime();
            long whole1 = end1 - start1;
            System.out.println(n + ", " +/*a[n]*+*/"= " + whole1);
        }
        //you dont need this code even for the other one quick sort
        System.out.println(" Median : " + pivotPickSTAT(a, 0, 511999));
        System.out.println("-----------------------------------------------------------------");
    }



    private static double[] readFiles(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextDouble()) {
                ctr++;
                s.nextDouble();
            }
            double[] num = new double[ctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < num.length; i++)
                num[i] = s1.nextDouble();
            return num;
        } catch (Exception e) {
            return null;
        }
    }

    private static void quicksortStat(double[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            double pivot = pivotPickSTAT(a, left, right);

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
            quicksortStat(a, left, i - 1); // Sort small elements
            quicksortStat(a, j + 1, right); // Sort large elements
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }
    private static void swapReferences(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

    private static double pivotPickSTAT(double[] a, int left, int right) {
//quartile:=PERCENTILE.EXC(ALLDATA[AllValues]);0,99999);
        double quatile = 0.5d;       //300000000d/*quatile*/
        double gammaStar = 300000000d * quatile(((left + right) / (2 * (a.length - 1))));

        return findMedianof5(new double[]{gammaStar, a[left], a[right],
                a[((2 * left) + right) / 3], a[(left + (2 * right)) / 3]});

    }

    private static double quatile(int i) {
        return i;
    }


}