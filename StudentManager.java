package myStudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        while (true) {
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1.添加学生");
            System.out.println("2·删除学生");
            System.out.println("3·修改学生");
            System.out.println("4·查看所有学生");
            System.out.println("5·退出");
            System.out.println("清输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    addStudent(array);
                    break;
                case 2:
                    deleteStudent(array);
                    break;
                case 3:
                    updateStudent(array);
                    break;
                case 4:
                    findAllStudent(array);
                    break;
                case 5:
                    return;
            }
        }
    }

    //修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("清输入要修改学生的学号");
        String sid = sc.nextLine();
        System.out.println("清输入要修改学生的姓名");
        String name = sc.nextLine();
        System.out.println("清输入要修改学生的年龄");
        String age = sc.nextLine();
        System.out.println("清输入要修改学生的居住地");
        String address = sc.nextLine();
        Student s = new Student(sid, name, age, address);
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                array.set(i, s);
                break;
            }
            if (i == (array.size() - 1)) {
                System.out.println("没有该学生信息，清输入");
                break;
            }
        }
    }

    //判断学号是否已使用
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (Student student : array) {
            if (student.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //添加学生
    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("清输入学生学号：");
            sid = sc.nextLine();

            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("您输入的学号已经使用，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("清输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("清输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("清输入学生居住地：");
        String address = sc.nextLine();
        Student s = new Student(sid, name, age, address);
        array.add(s);
        System.out.println("添加学生成功");

    }

    //查看所有学生
    public static void findAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加再查询！");
        } else {
            System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
            for (Student s : array) {
                System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());
            }
        }
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("清输入要删除学生的学号");
        String sid = sc.nextLine();
        if (array.size() == 0) {
            System.out.println("还未输入学生信息，请先输入！！！");
        } else {
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                if (s.getSid().equals(sid)) {
                    array.remove(i);
                    System.out.println("删除成功");
                    break;
                } else if ((array.size() - 1) == i) {
                    System.out.println("没有该学生信息，请检查");
                    break;
                }
            }
        }
    }

}
