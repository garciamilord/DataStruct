package com.company;
import java.util.*;

public class CAQueue {
    private int front,back;
    private int sz;
    private long max=1000000;
    ArrayList<Long> a;
    CAQueue(){
        front=0;back=0;
        sz=0;
        a=new ArrayList<Long>(Math.toIntExact(max));

    }
    boolean isEmpty()
    {
        if(sz==0)
            return true;
        return false;
    }
    boolean isFull()
    {
        if(sz==max)
            return true;
        return false;
    }
    void enqueue(Long e){
        if(!isFull()){
            a.add(e);
            back++;
            sz++;
        }
    }
    void dequeue(){
        if(a.size()!=0){
            a.remove(0);
            front++;
            sz--;
        }
    }

}



