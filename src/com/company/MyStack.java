package com.company;
import java.util.*;

public class MyStack {

    ArrayList<Long> stack;
    int top,max;
    MyStack(int n)
    {
        stack=new ArrayList<Long>((int)max);
        max=n;
        top=0;
    }
    void push(Long item)
    {
        if(top==max)
        {

            return;
        }
        stack.add(item);
        top++;

    }
    long pop()
    {
        if(top==0)
        {

            return -1;
        }
        else
        {
            long t=stack.remove(--top);
            return t;
        }


    }
    boolean isEmpty()
    {
        if(top==0)
            return true;
        return false;
    }
    int size()
    {
        return top;
    }

}

