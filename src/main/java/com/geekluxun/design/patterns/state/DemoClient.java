package com.geekluxun.design.patterns.state;

import java.util.Scanner;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 11:08
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        WordStateMachine machine = new WordStateMachine();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a char : ");
            machine.inputWord(sc.next().charAt(0));
        }
    }
}
