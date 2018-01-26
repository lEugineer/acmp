package t579;

/*
Дана последовательность целых чисел. Требуется найти подпоследовательность заданной последовательности с максимальным модулем суммы входящих в нее чисел. Напомним, что модуль целого числа x равняется x, если x ≥ 0 и -x, если x < 0.

Входные данные
Первая строка входного файла INPUT.TXT содержит натуральное число n (1 ≤ n ≤ 10000) - длину последовательности. Во второй строке записаны n целых чисел, по модулю не превосходящих 10000.

Выходные данные
В первой строке выходного файла OUTPUT.TXT выведите длину k выбранной вами подпоследовательности. Во второй строке должны быть записаны k различных чисел, разделенных пробелами - номера выбранных членов последовательности.

Пример
in:
5
-1 4 -1 6 -7

out:
2 4
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class T579 {
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] seq = new int[n];
        String[] in = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(in[i]);
        }

        long sum = 0;
        LinkedList<Integer> pos = new LinkedList<>();
        LinkedList<Integer> neg = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (seq[i] < 0) {
                neg.addLast(i+1);
            } else {
                pos.addLast(i+1);
            }
            sum += seq[i];
        }

        LinkedList<Integer> result = neg;
        if (sum > 0) {
            result = pos;
        }

        StringBuilder builder = new StringBuilder();
        for (Integer i: result) {
            builder.append(i);
            builder.append(" ");
        }
        if (builder.length() > 1)
            builder.deleteCharAt(builder.length()-1);

        System.out.println(result.size());
        System.out.println(builder);
    }
}
