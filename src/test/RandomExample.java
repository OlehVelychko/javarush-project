package test;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
//        int x = (int) (Math.random() * 10);
        Random random = new Random();
        int x = random.nextInt(100);
        System.out.println(x);
    }
}
