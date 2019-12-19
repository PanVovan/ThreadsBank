package com.company;

public class Take extends Thread {
    public static  boolean flag = true;
    @Override
    public  void  run(){
        while (flag){
        Bank.take((int)(Math.random()*1000));
        }
    }
}