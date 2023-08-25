package com;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCode());
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

        //把字符串变为字符数组
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char temp = arr[randomIndex];
        arr[randomIndex]=arr[arr.length-1];
        arr[arr.length-1]=temp;
        return new String(arr);
    }
}
