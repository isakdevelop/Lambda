package com.dennis.api;

import com.dennis.api.enums.MainEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("e - Exit \n" +
                    "u - User\n" +
                    "a - Article\n" +
                    "b - Board\n" +
                    "c - Crawler\n" +
                    "m - Account");

            System.out.print("input command : ");
            MainEnum command = MainEnum.getByCommand(sc.next());
            running = command.performAction(sc);
        }
    }
}
