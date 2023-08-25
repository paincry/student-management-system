package com;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码 4退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        String username;
        //键盘录入用户名
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("用户名格式不正确，请重新输入");
                continue;
            }
            boolean flag2 = contains(list, username);
            if (flag2) {
                System.out.println("用户名" + username + "已存在，请重新输入");
            } else {
                System.out.println("用户名" + username + "可用");
                break;
            }
        }

        //键盘录入密码
        String password;
        while (true) {
            System.out.println("请输入要注册的密码");
            password = sc.next();
            System.out.println("请再次输入要注册的密码");
            String againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            } else {
                System.out.println("两次密码一致，继续录入其他数据");
                break;
            }
        }

        //键盘录入身份证号码
        String personID;
        while (true) {
            System.out.println("请输入身份证号码");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if (flag) {
                System.out.println("身份证号码满足要求");
                break;
            } else {
                System.out.println("身份证号码格式有误，请重新输入");
                continue;
            }
        }

        //键盘录入手机号码
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if (flag) {
                System.out.println("手机号码格式正确");
                break;
            } else {
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }
        }


        //将键盘录入的信息添加到student对象中
        User u = new User(username, password, personID, phoneNumber);
        list.add(u);
        System.out.println("注册成功");

        printlist(list);
    }

    private static void printlist(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(user.getUsername() + "," + user.getPassword() + "," + user.getPersonID() + "," + user.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }

        if (phoneNumber.startsWith("0")) {
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonID(String personID) {
        if (personID.length() != 18) {
            return false;
        }

        if (personID.startsWith("0")) {
            return false;
        }

        for (int i = 0; i < personID.length(); i++) {
            char c = personID.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        char endChar = personID.charAt(personID.length() - 1);
        if ((endChar >= '0' && endChar <= '9') || (endChar == 'x') || (endChar) == 'X') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean contains(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String rightUsername = user.getUsername();
            if (rightUsername.equals(username))
                return true;
        }
        return false;
    }

    private static boolean checkUsername(String username) {
        int len = username.length();
        if (len < 3 || len > 15) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a') && (c <= 'z') || (c >= 'A') && (c <= 'Z') || (c >= '0') && (c <= '9'))) {
                return false;
            }
        }

        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }

    private static void login(ArrayList<User> list) {
        System.out.println("登录");
    }

    private static void forgetPassword(ArrayList<User> list) {
        System.out.println("忘记密码");
    }


}
