package com;

import java.lang.reflect.Array;
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
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    public static void addStudent(ArrayList<student> list) {
        student s = new student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生的id");
            String id = sc.next();
            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("id以及存在，请重新录入");
            } else {
                s.setId(id);
                break;
            }
        }


        System.out.println("请输入学生的姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);

        System.out.println("学生信息添加成功");
    }

    public static void deleteStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("id为:" + id + "的学生删除成功");
        } else {
            System.out.println("id不存在，删除失败");
        }
    }

    public static void updateStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("要修改的id" + id + "不存在");
            return ;
        }
        student stu = list.get(index);
        System.out.println("请输入要修改的学生姓名");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("请输入要修改的学生年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);

        System.out.println("请输入要修改的学生家庭住址");
        String newAddress = sc.next();
        stu.setAddress(newAddress);

        System.out.println("学生信息修改成功");
    }

    public static void queryStudent(ArrayList<student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息");
            return;
        }

        System.out.println("id\t姓名\t年龄\t家庭住址\t");
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }


    }

    public static boolean contains(ArrayList<student> list, String id) {
        return getIndex(list, id) >= 0;
    }

    public static int getIndex(ArrayList<student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);
            String sid = stu.getId();
            if (sid.equals(id)) {
                return i;
            }
        }
        return -1;
    }


}
