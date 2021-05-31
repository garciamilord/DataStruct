package com.company;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        long a[] = {20, 50, 100, 1000, 10000, 100000, 1000000}, n;
        long i;
        int k;
        System.out.println("Running time when CAQueue is Applied");
        for (k = 0; k < a.length; k++) {
            n = a[k];
            CAQueue CAQ = new CAQueue();
            for (i = 0; i < n; i++) {
                CAQ.enqueue(i);
            }
            long startTime = System.nanoTime();
            for (i = 0; i < n; i++) {
                CAQ.enqueue(i + n);
                CAQ.dequeue();
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(n + "," + totalTime);


        }

        System.out.println("Running time when SSQueue is Applied");
        for(k=0;k<a.length;k++)
        {
            n=a[k];
            SSQueue SSQ=new SSQueue();
            for(i=0;i<n;i++){
                SSQ.enqueue(i);
            }
            long startTime=System.nanoTime();
            for(i=0;i<n;i++){
                SSQ.enqueue(i+n);
                SSQ.dequeue();
            }
            long endTime=System.nanoTime();
            long totalTime=endTime-startTime;
            System.out.println(n+","+totalTime);


        }



    }



    }






