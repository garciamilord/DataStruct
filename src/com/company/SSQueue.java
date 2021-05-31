package com.company;
import java.util.*;

public class SSQueue {
    private int front,rear;
    private int s0;
    private long max=1000000;
    MyStack s1,s2;
    SSQueue(){
        front=0;rear=0;
        s0=0;
        s1=new MyStack((int)max);
        s2=new MyStack((int)max);
    }
    boolean isEmpty()
    {
        if(s0==0)
            return true;
        return false;
    }
    boolean isFull()
    {
        if(s0==max)
            return true;
        return false;
    }
    void enqueue(Long e){
        if(!isFull()){
            s1.push(e);
            rear++;
            s0++;
        }
    }
    void dequeue(){
        if(!isEmpty()){
            if(!s1.isEmpty()&&s2.isEmpty())
            {
                while(!s1.isEmpty())
                    s2.push(s1.pop());
                s2.pop();
                while(!s2.isEmpty())
                    s1.push(s2.pop());

            }
            front++;
            s0--;

        }
    }

}

