package org.yk.algorithm.sort;
import java.util.LinkedList;

// 归并排序
public class MergerSort {

    // 归并
    private LinkedList<Integer> merger(LinkedList<Integer> aNum, LinkedList<Integer> bNum){
        int condition = aNum.size() + bNum.size();
        LinkedList<Integer>  new_Num = new LinkedList<Integer> ();
        while (0 < condition){
            // a被取完情况
            if(aNum.size() == 0){
                new_Num.addAll(bNum);
                break;
            }
            // b被取完情况
            if(bNum.size() == 0){
                new_Num.addAll(aNum);
                break;
            }
            if(aNum.get(0) > bNum.get(0)){
                new_Num.add(bNum.get(0));
                bNum.remove(0);
            }else{
                new_Num.add(aNum.get(0));
                aNum.remove(0);
            }
            condition--;
        }
        return new_Num;
    }

    public LinkedList<Integer> sort(LinkedList<Integer> num){
        if (num.size() > 1){
            return divide(half(num, 0, num.size()/2)
                    , half(num, num.size()/2, num.size()));
        }
        return num;
    }

    // 分治
    private LinkedList<Integer>  divide(LinkedList<Integer>  aNum, LinkedList<Integer> bnum){
        if(aNum.size() != 1){
            aNum = divide(half(aNum, 0, aNum.size()/2)
                    ,half(aNum, aNum.size()/2, aNum.size()));
        }
        if(bnum.size() != 1){
            bnum = divide(half(bnum, 0, bnum.size()/2)
                    ,half(bnum, bnum.size()/2, bnum.size()));
        }
        return merger(aNum, bnum);
    }

    private LinkedList<Integer> half(LinkedList<Integer> num, int begin, int end){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = begin;i < end; i++){
            list.add(num.get(i));
        }
        return list;
    }
}
