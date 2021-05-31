package com.company;

public class Scenario2 {


    public static void main(String[] args) {
        long b[] = {20, 50, 100, 1000, 10000, 100000, 1000000}, m;
        long p, q;
        int l;
        System.out.println("Random....\nRunning time when CAQueue is Applied");
        for (l = 0; l < b.length; l++) {
            m = b[l];
            CAQueue circle = new CAQueue();
            for (p = 0; p < m; p++) {
                circle.enqueue(p);
            }
            long startTime = System.nanoTime();
            for (p = 0; p < m; p++) {
                if (Math.random() < 0.5)
                    circle.enqueue(p + m);
                circle.dequeue();
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(m + "," + totalTime);

        }
        System.out.println("Running time when SSQueue is Applied");
        for(l=0;l<b.length;l++)
        {
            m=b[l];
            SSQueue stack=new SSQueue();
            for(p=0;p<m;p++){
                stack.enqueue(p);
            }
            long startTime=System.nanoTime();
            for(p=0;p<m;p++){
                if(Math.random()<0.5)
                    stack.enqueue(p+m);
                stack.dequeue();
            }
            long endTime=System.nanoTime();
            long totalTime=endTime-startTime;
            System.out.println(m+","+totalTime);


        }

    }
}



