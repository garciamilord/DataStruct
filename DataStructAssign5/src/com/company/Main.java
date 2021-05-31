package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {



        Scanner sc = new Scanner(new File("C:\\\\Users\\\\admin\\\\IdeaProjects\\\\DataStructAssign5\\\\src\\\\com\\\\company\\\\exchange rates.csv\\\\"));

        String[] line = sc.nextLine().split(",");
        String[] money = Arrays.copyOfRange(line, 1, line.length);
        Graph g = new Graph(money.length, money.length * money.length);

        int edgeIndex = 0;
        int to = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine().split(",");
            String[] rates = Arrays.copyOfRange(line, 1, line.length);
            for (int from = 0; from < rates.length; from++) {
                g.edge[edgeIndex].src = from;
                g.edge[edgeIndex].dest = to;
                g.edge[edgeIndex].weight = Double.parseDouble(rates[from]);
                edgeIndex++;
            }
            to++;
        }


        double[] USD = g.bellmanFord(53);
        System.out.println("Source currency is " + money[53]);
        for (int i = 0; i < USD.length; i++) {
            System.out.println(money[i] + ": max exchange rate is " + USD[i] + " and direct rate is " + g.edge[53 * money.length + i].weight);
        }

        System.out.println("\n");


        double[] Euro = g.bellmanFord(4);
        System.out.println("Source currency is " + money[4]);
        for (int i = 0; i < Euro.length; i++) {
            System.out.println(money[i] + ": max exchange rate is " + Euro[i] + " and direct rate is " + g.edge[4 * money.length + i].weight);
        }

        System.out.println("\n");


        double[] BritishPound = g.bellmanFord(3);
        System.out.println("Source currency is " + money[3]);
        for (int i = 0; i < BritishPound.length; i++) {
            System.out.println(money[i] + ": max exchange rate is " + BritishPound[i] + " and direct rate is " + g.edge[3 * money.length + i].weight);
        }


    }


}