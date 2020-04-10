package org.yk;

import java.util.Random;

class SuperClass{
    public static int value = 123;
    public static final int fv = 123;
    static{
        System.out.println("SuperClass.static initializer");
    }
}

class SubClass extends SuperClass{
    static{
        System.out.println("SubClass.static initializer");
    }
}

public class Main {

    public static void main(String [] args){
//        SuperClass [] superClasses = new SubClass[10];
//        StaticClass.sta.getIn();
//        StaticClass.sta.print();
//        StaticClass.getInstance().print();
        printColor();
    }
    public static void printColor() {
        // 背景颜色代号(41-46)
        // 前景色代号(31-36)
        //前景色代号和背景色代号可选，就是或可以写，也可以不写
        // 数字+m：1加粗；3斜体；4下划线
        // 格式：System.out.println("\33[前景色代号;背景色代号;数字m");
        Random backgroundRandom = new Random();
        Random fontRandom = new Random();
        for (int i = 1; i <= 50; i++) {
            int font = fontRandom.nextInt(6) + 31;
            int background = backgroundRandom.nextInt(6) + 41;
            System.out.format("\033[0m前景色是%d,背景色是%d------\33[%d;%d;0m正在测试%n", font, background, font, background);
        }
    }
}

class StaticClass{
    private static StaticClass sta = new StaticClass();// 1   0
    private static int c1;
    private static int c2 = 0;
    // private static StaticClass sta = new StaticClass();// 1   1

    private StaticClass(){
        c1++;
        c2++;
    }

    public static StaticClass getInstance(){
        return sta;
    }

    public void print(){
        System.out.println("c1:" + c1 + " === c2:" + c2);
    }


}
