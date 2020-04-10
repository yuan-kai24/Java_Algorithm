package org.yk.algorithm.C201903;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {
    final static String[] result = {"Yes", "No"};

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<String> str = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            String info = scanner.next();
            str.add(info);
        }

        for (int i = 0; i < str.size(); i++) {
            System.out.println(result[returnResult(str.get(i))]);

        }
//        System.out.println(result[returnResult("5/2x2x6")]);
        scanner.close();*/
        Main();
    }

    public static int returnResult(String math_string) {
        int result = 1;
        float[] num = new float[4];
        char math[] = new char[3];

        // 拆分数字和运算符
        int n = 0;
        int m = 0;
        String nums = "";

        for (int i = 0; i < math_string.length(); i++) {
            if (47 < math_string.charAt(i) && math_string.charAt(i) < 58) {
                nums += math_string.charAt(i);
            } else {
                num[n] = Float.valueOf(nums);
                math[m] = math_string.charAt(i);
                n++;
                m++;
                nums = "";
            }
        }
        num[n] = Float.valueOf(nums);

        int yx = 0;// 优先运算
        // 统计优先运算符

        for (int i = 0; i < math.length; i++) {
            if (math[i] != '+' && math[i] != '-') {
                yx++;
            }
        }

        // 排列计算顺序
        boolean mc[] = new boolean[3];// 已平判断的运算符
        int order[] = new int[6]; // 顺序
        int on = 0; // 顺序下标
        if (yx == 3 || yx == 0) {
            order = new int[]{0,1,1,2,2,3};
        } else {
            for (int i = 0; i < math.length; i++, yx--) {
                for (int j = 0; j < math.length; j++) {
                    if (yx > 0) {
                        // 乘除运算
                        if (math[j] != '+' && math[j] != '-') {
                            if (!mc[j]) {
                                mc[j] = true;
                                switch (j) {
                                    case 0:
                                        order[on] = 0;
                                        order[on + 1] = 1;
                                        break;
                                    case 2:
                                        order[on] = 2;
                                        order[on + 1] = 3;
                                        break;
                                    case 1:
                                        order[on] = 1;
                                        order[on + 1] = 2;
                                        break;
                                }
                                on += 2;
                                break;
                            }
                        }
                    } else {
                        // 加减运算
                        if ((math[j] == '+' || math[j] == '-')) {
                            if (!mc[j]) {
                                mc[j] = true;
                                switch (j) {
                                    case 0:
                                        order[on] = 0;
                                        order[on + 1] = 1;
                                        break;
                                    case 1:
                                        order[on] = 1;
                                        order[on + 1] = 2;
                                        break;
                                    case 2:
                                        order[on] = 2;
                                        order[on + 1] = 3;
                                        break;
                                }
                                on += 2;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // 计算 --- 把计算的两个数分别归置到原来的数组里

        float s1 = cap(num[order[0]],num[order[1]],math[order[0]]);
        num[order[0]] = s1;
        num[order[1]] = s1;
        float s2 = cap(num[order[2]],num[order[3]],math[order[2]]);
        num[order[2]] = s2;
        num[order[3]] = s2;
        float s3 = cap(num[order[4]],num[order[5]],math[order[4]]);
        num[order[4]] = s3;
        num[order[5]] = s3;

        if(s3 == 24)result = 0;
        return result;
    }

    // 四则运算
    public static float cap(float f1, float f2, char m) {
        float result = 0;
        switch (m) {
            case '+':
                result = f1 + f2;
                break;
            case '-':
                result = f1 - f2;
                break;
            case 'x':
                result = f1 * f2;
                break;
            case '/':
                result = (float) Math.floor((double) (f1 / f2));
                break;
        }
//        System.out.println(f1 + "" + m + f2 + "=" + result);
        return result;
    }

    // 满分版
    public static void Main(){
        Scanner sc = new Scanner(System.in);

        //存储每一次输入的算术字符串
        List<String> list= new ArrayList<String>();

        //有几个这种字符串
        int n = sc.nextInt();

        //存储最终的结果"Yes" "No"
        String[] result = new String[n];

        //开始输入 beging
        for(int i = 0;i<n;i++){

            //输入的算术字符串
            String str = sc.next();

            //每一次输入算术字符串都把list清空，上一次输入残留的字符串不要了
            list.clear();

            //将输入的运算公式放在一个String数组中
            for(int j = 0;j<str.length();j++){
                list.add(str.substring(j,j+1));
            }


            //将乘法和除法解决掉，让剩下的字符串只包含加减运算
            for(int w = 0;w<list.size()-1;w++){
                //如果是乘法运算符"x"
                if(list.get(w).equals("x")){
                    //取出这个符号两边的数字
                    int num1 = Integer.parseInt(list.get(w-1));
                    int num2 = Integer.parseInt(list.get(w+1));
                    //把结果变成字符串放在target变量中
                    String target = (num1*num2)+"";
                    //把w+1和w位置的元素移除
                    list.remove(w+1);
                    list.remove(w);
                    list.set(w-1, target);
                    //从头再找，看有没有"x"
                    w = 0;
                }else if(list.get(w).equals("/")){
                    //取出这个符号两边的数字
                    int num1 = Integer.parseInt(list.get(w-1));
                    int num2 = Integer.parseInt(list.get(w+1));
                    //把结果变成字符串放在target变量中
                    String target = (num1/num2)+"";
                    //把w+1和w位置的元素移除
                    list.remove(w+1);
                    list.remove(w);
                    list.set(w-1, target);
                    //从头再找，看有没有"/"
                    w = 0;
                }
            }

            //处理加减运算
            for(int y = 0;y<list.size()-1;y++){
                if(list.get(y).equals("+")){
                    //取出这个符号两边的数字
                    int num1 = Integer.parseInt(list.get(y-1));
                    int num2 = Integer.parseInt(list.get(y+1));
                    //把结果变成字符串放在target变量中
                    String target = (num1+num2)+"";
                    //把w+1和w位置的元素移除
                    list.remove(y+1);
                    list.remove(y);
                    list.set(y-1, target);
                    //从头再找，看有没有"+"
                    y = 0;
                }else if(list.get(y).equals("-")){
                    //取出这个符号两边的数字
                    int num1 = Integer.parseInt(list.get(y-1));
                    int num2 = Integer.parseInt(list.get(y+1));
                    //把结果变成字符串放在target变量中
                    String target = (num1-num2)+"";
                    //把w+1和w位置的元素移除
                    list.remove(y+1);
                    list.remove(y);
                    list.set(y-1, target);
                    //从头再找，看有没有"+"
                    y = 0;
                }

            }

            //到这里list中就只剩一个元素了
            if(Integer.parseInt(list.get(0))==24){
                result[i] = "Yes";
            }else{
                result[i] = "No";
            }


        }//end

        sc.close();
        for(int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
