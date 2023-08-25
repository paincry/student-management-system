package com;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        getCode();
    }

    private static String getCode() {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int inedx = r.nextInt(list.size());
            char c = list.get(inedx);
            sb.append(c);
        }

        //把一个随机数字添加到末尾
        int number = r.nextInt(10);
        sb.append(number);

        System.out.println(sb);
        return "";
    }
}
