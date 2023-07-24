package com;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {

    public static void main(String[] args) {
        ArrayList<student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("-----------------欢迎来到学生管理系统--------------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent( list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    public static void addStudent(ArrayList<student> list){
        System.out.println("添加学生");
    }

    public static void deleteStudent(ArrayList<student> list){
        System.out.println("删除学生");
    }

    public static void updateStudent(ArrayList<student> list){
        System.out.println("修改学生");
    }

    public static void queryStudent(ArrayList<student> list){
        System.out.println("查询学生");
    }



}
