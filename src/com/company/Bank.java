package com.company;

public class Bank {
    public  static int balance;
    private static final Object key = new Object();

    public static void give(int summ) {
        try {
            synchronized (key) {
                balance += summ;
                System.out.println("На балансе : "+ balance  + " рублей   Пополнение: " + summ+" рублей");
                Thread.sleep(400);
                key.notify();
                key.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void take(int summ) {
        try {
            synchronized (key) {
                if (summ <= balance) {
                    balance -= summ;
                    System.out.println("На балансе : "+ balance  + " рублей   Убыток: " + summ +" рублей");
                    Thread.sleep(400);
                    key.notify();
                    key.wait();
                }
                else {
                    Give.flag = false;
                    Take.flag = false;
                    System.out.println("На балансе недостаточно средств");
                }
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

