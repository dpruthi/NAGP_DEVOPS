package org.nagp;

public class Main {

    public static void main(String[] args) {
        if (true) {
            System.out.println("hello");
        }else if (false){
            System.out.println("hello");
        }
        System.out.println("hello");
        add(2, 2);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}