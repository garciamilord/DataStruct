package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Scenario2 {
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

        PriorityQueue Q = new PriorityQueue(25);


        for (int i = 0; i < 25; i++) {
            Q.add(a[i][0]);
            index[i] = 0;
        }

        for (int i = 1; i < 250000 - 25; i++) {
            long min = (long) Q.remove();
            if (min != -1)
                total.add(min);
            for (int k = 0; k < 25; k++) {
                if (index[k] != 10000) {
                    if (a[k][index[k]] == min) {
                        index[k]++;
                        if (index[k] < a[0].length) {
                            Q.add(a[k][index[k]]);
                            break;
                        }

                    }
                }
            }

            totalTime += (System.nanoTime() - startTime);
            System.out.println(i+" PriorityQueue " + totalTime);
        }




    }

    }
