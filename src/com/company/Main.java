package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Bank.balance = scan.nextInt();

        Give g = new Give();
        g.start();


        Take t = new Take();
        t.start();

        try {
            g.join();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
