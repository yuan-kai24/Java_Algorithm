package org.yk;

import org.yk.algorithm.sort.MergerSort;

import java.util.LinkedList;
import java.util.LinkedList;

/**
 * @program: algorithm
 * @ClassName MergerSort
 * @description:
 * @author: YuanKai
 * @create: 2020-04-10 21:17
 * @Version 1.0
 **/


public class Main {

    public static void main(String [] args){
//        LinkedList<Integer> list = new LinkedList<>();
//        new Main().Num(0,0, list);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0;i < 49;i++){
//            list.add(Math.random())
            list.add((int) (Math.random()*200));
        }
        System.out.println("排序前：" + list);
        System.out.println("排序后：" + new MergerSort().sort(list));
    }

    public void Num(int point, int count, LinkedList<Integer> list){
        if(count == 10){
            System.out.println(list);
            return;
        }
        if (count > 10){
            return;
        }
        for(int i : new int[]{1, 2, 5, 10}){
            list.add(i);
            Num(point+1, count+i, list);
            list.remove(point);
        }
    }



    public static void GBsort(int [] num){

    }

}
