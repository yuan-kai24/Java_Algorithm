package org.yk.algorithm;

import org.yk.datastructure.MyList;

public class Main {
    public static void main(String [] args){
        MyList<String> myList = new MyList<>();
        myList.add("111");
        myList.add("222");
        myList.add("333");
        myList.add("444");
        myList.add("555");
        myList.add("666");
        myList.add("777");
        myList.add("888");
        myList.add("999");

        System.out.println("mylist有：" + myList.getLength() + "个数据");
        myList.update(9,"我在修改");
        System.out.println("mylist有：" + myList.getLength() + "个数据");
        System.out.println("mylist的第二个数据为：" + myList.get(9));
        myList.del(null);
        System.out.println(myList);

    }
}
