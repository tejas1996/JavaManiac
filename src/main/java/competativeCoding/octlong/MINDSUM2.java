package competativeCoding.octlong;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class MINDSUM2 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {

            HashSet<Long> integers = new HashSet<>();
            long n = scanner.nextLong();
            long d = scanner.nextLong();
            int count = 0;
            long sin = n;
            while (true) {

                while ((sin / 10) != 0) {
                    sin = getDigSum(sin);
//                    count--;
                }
                if (!integers.contains(sin)) {
//                    count++;
                    integers.add(sin);
//                    count++;
                    sin = sin + d;
                } else {
                    break;
                }

            }

            long ans = Collections.min(integers);

            if (ans == n) {
                System.out.println(ans + " 0");
                t--;
                continue;
            }

//            System.out.println("hey");


            Queue<Sweet> integers2 = new LinkedList<>();
            HashMap<Long, Long> hashset = new HashMap<>();

            long dig = getDigSum(n);
            long val = n + d;

            if (dig == ans) {
                System.out.println(ans + " 1");
            } else {

                int remem;
                integers2.add(new Sweet(dig, 1));
                integers2.add(new Sweet(val, 1));
                while (true) {


                    Sweet ele = integers2.remove();
                    if (ans == ele.num) {
                        break;
                    }
                    count++;
                    long digSum = getDigSum(ele.num);
                    long add = ele.num + d;

                    if (!hashset.containsKey(digSum)) {
                        hashset.put(digSum, ele.remem + 1);
                        integers2.add(new Sweet(digSum, ele.remem + 1));
                    }
                    if (!hashset.containsKey(add)) {
                        hashset.put(add, ele.remem + 1);
                        integers2.add(new Sweet(add, ele.remem + 1));
                    }

                }

                System.out.println(ans + " " + hashset.get(ans));
            }
            t--;
        }


    }

    public static long getDigSum(long m) {

        long sum = 0;
        long n;
        while (m > 0) {
            n = m % 10;
            sum = sum + n;
            m = m / 10;
        }
        return sum;

    }

}
