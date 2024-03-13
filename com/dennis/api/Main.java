package com.dennis.api;

import com.dennis.api.enums.MainEnum;

import java.util.Scanner;

import static com.dennis.api.enums.MainEnum.performAction;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            running = performAction(sc);
        }
    }
}
