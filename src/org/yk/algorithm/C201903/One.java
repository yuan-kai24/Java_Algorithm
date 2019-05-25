package org.yk.algorithm.C201903;

import java.util.*;

// 小中大
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int count = scanner.nextInt();
        int i1 = count / 2;
        int qt = 0;
        String xs = "";
        boolean a = false;
        for (int i = 0; i < count; i++) {

            if (i == 0 || i == i1 || i == (count - 1)) {
                if (i != i1 || !a)
                    list.add(scanner.nextInt());
                else {
                    if (qt != 0) {
                        int i2 = scanner.nextInt() + qt;
                        list.add(i2/2);
                        if (i2 % 2 == 1) {
                            xs = String.format("%.1f",Double.valueOf(i2+"")/2 - i2/2);
                            xs = xs.substring(1, xs.length());
                        }
                    }
                }
            } else {
                if (i == (i1 - 1) && count % 2 == 0) {
                    qt = scanner.nextInt();
                    a = true;
                } else
                    scanner.nextInt();
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
            System.out.print(list.get(0) + " ");
            System.out.print(list.get(1) + xs + " ");
            System.out.print(list.get(2) + " ");

    }
}
