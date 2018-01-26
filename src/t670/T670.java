package t670;
/*
*Антон записал ряд натуральных чисел в порядке возрастания: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 и т.д. Затем вычеркнул из него все числа, в которых имеется хотя бы две одинаковых цифры, и получил последовательность: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23 и т.д.

Вам необходимо по заданному N найти N-ое по счету число в получившейся последовательности.

Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число N (1 ≤ N ≤ 10000).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести N-ое по счету число без одинаковых цифр.
in: 100
out: 123

!!!хэш массивы в разы медленней

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T670 {
    public static void main(String[] args) throws Throwable {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int result = 0;
        Integer[] digits = new Integer[5];

        COUNTER: for(int digitIndex = 0; x > 0; digitIndex = 0) {
            ++result;

            for (int tmp = result; tmp != 0; tmp /= 10 ) {
                digits[digitIndex] = tmp % 10;

                for (int j=0; j < digitIndex; j++) {
                    if (digits[j] == digits[digitIndex]) {
                        continue COUNTER;
                    }
                }

                digitIndex++;
            }

            --x;
        }

        System.out.println(result);
    }
}
