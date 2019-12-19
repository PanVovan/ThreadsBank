package com.company;

public class Give extends Thread {
    public static  boolean flag = true;

    @Override
    public  void  run() {
        while (flag) {
            Bank.give((int) (Math.random() * 1000));
        }
    }
}


