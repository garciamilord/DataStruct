package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Scenario1 {

    public static void main(String[] args) throws FileNotFoundException {

        long startTime = System.nanoTime();
        long totalTime = 0;

        Scanner sc = new Scanner(new File("C:\\Users\\admin\\IdeaProjects\\DaaStructAssign4\\src\\" + "in.csv"));
        long a[][] = new long[25][10000];
        for (int i = 0; i < a.length; i++) {

            Scanner line = new Scanner(sc.nextLine());

            line.useDelimiter(",");
            for (int j = 0; j < a[0].length; j++) {

                a[i][j] = line.nextLong();

            }

        }

        startTime = System.nanoTime();

        ArrayList<Long> total = new ArrayList<Long>();

        int index[] = new int[25];

        BinaryHeap b = new BinaryHeap(25);
        for (int i = 0; i < 25; i++) {
            b.insert(a[i][0]);
            index[i] = 0;

        }
        for (int i = 1; i < 250000 - 25; i++) {
            long min = (long) b.deleteMin();
            if (min != -1)
                total.add(min);
            for (int k = 0; k < 25; k++) {
                if (index[k] != 10000) {
                    index[k]++;
                    if (index[k] < a[0].length) {
                        b.insert(a[k][index[k]]);
                        break;
                    }
                }
            }
            totalTime += (System.nanoTime() - startTime);
            System.out.println(i+" BinaryHeap " + totalTime);
        }


    }
}
