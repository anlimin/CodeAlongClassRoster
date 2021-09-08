package ca.limin.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner input = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return input.next();
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.print(prompt);
        int n;
        do {
            n = readInt(prompt);
        } while (n < min || n > max);
        return n;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.print(prompt);
        return input.nextDouble();
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.print(prompt);
        double n;
        do {
            n = readDouble(prompt);
        } while (n < min || n > max);
        return n;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.print(prompt);
        return input.nextFloat();
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.print(prompt);
        float n;
        do {
            n = readInt(prompt);
        } while (n < min || n > max);
        return n;
    }

    @Override
    public long readLong(String prompt) {
        System.out.print(prompt);
        return input.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.print(prompt);
        long n;
        do {
            n = readInt(prompt);
        } while (n < min || n > max);
        return n;
    }
}
