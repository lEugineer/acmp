package t557;
/*
* Матрицы
(Время: 2 сек. Память: 16 Мб Сложность: 42%)
Аня недавно узнала, что такое квадратная матрица размерности n. Это таблица n×n с целыми числами в ячейках. Число, стоящее на пересечении i-ой строки и j-ого столбца матрицы A, кратко обозначается A[i, j]. Матрицы можно умножать, и Аня быстро освоила, как запрограммировать эту операцию с помощью циклов. Результатом умножения двух матриц A и B будет матрица C, элементы которой определяются следующим образом:

Матрицы ей понадобились для конкретной задачи, в которой надо узнать определенный элемент произведения нескольких матриц. Это уже достаточно сложная задача для Ани, но она усложняется тем, что все вычисления ведутся по модулю некоторого простого числа p, то есть если при арифметических операциях получается число, большее, либо равное p, оно заменяется на остаток при делении на p.

Помогите Ане вычислить нужный ей элемент.

Входные данные
В первой строчке входного файла INPUT.TXT стоят два числа: m - количество матриц, n - размер каждой из матриц (1 ≤ m ≤ 130, 1 ≤ n ≤ 130). В следующей строчке содержатся номер строки и столбца, интересующего Аню элемента 1 ≤ a ≤ n, 1 ≤ b ≤ n. В третьей строке содержится простое число p ≤ 1000. Далее следует описание m матриц. Описание каждой матрицы состоит из n строк. В каждой из строк содержится n неотрицательных целых чисел, меньших p. Соседние числа в строке разделены пробелом, а перед каждой матрицей пропущена строка.

Выходные данные
В выходной файл OUTPUT.TXT выведите нужный Ане элемент произведения матриц.
in:
3 2
1 2
239

1 2
3 4

4 2
1 3

1 2
2 1

out:
20

* */
import java.io.*;
import java.util.Arrays;

public class T557 {

    private static int m;
    private static int n;

    private static int a;
    private static int b;

    private static int p;

    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readMN (reader);
        readAB (reader);
        readP (reader);

        Integer[] mul = readMatrix (reader)[a-1];

        for (int i = 0; i < m-1; i++) {
            mul = mulMatrixLine(mul, readMatrix (reader));
        }

        System.out.println(mul[b-1]);
    }

    private static Integer[] mulMatrixLine(Integer[] m1, Integer[][] m2) {
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);
        for (int j = 0; j < n; j++) {

            for (int k = 0; k < n; k++) {
                result[j] += m1[k] * m2[k][j];
            }

            result[j] = result[j] % p;
        }

        return result;
    }

    private static void readMN (BufferedReader reader) throws IOException {
        String[] args = readLineArgs (reader);

        m = Integer.parseInt (args[0]);
        n = Integer.parseInt (args[1]);
    }

    private static void readAB (BufferedReader reader) throws IOException {
        String[] args = readLineArgs (reader);

        a = Integer.parseInt (args[0]);
        b = Integer.parseInt (args[1]);
    }

    private static void readP (BufferedReader reader) throws IOException {
        p = Integer.parseInt(readLineArgs (reader)[0]);
    }

    private static Integer[][] readMatrix(BufferedReader reader) throws IOException {
        String[] args;
        readLineArgs (reader);

        Integer[][] matrix = new Integer[n][];
        for (int i=0; i < n; i++) {
            args = readLineArgs (reader);

            Integer[] row = new Integer[n];
            for (int j=0; j < n; j++) {
                row[j] = Integer.parseInt(args[j]);
            }

            matrix[i] = row;
        }

        return matrix;
    }

    private static String[] readLineArgs (BufferedReader reader) throws IOException {
        return reader.readLine().split(" ");
    }
}