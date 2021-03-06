package t278;
/*
* Вычислительная биология
(Время: 2 сек. Память: 16 Мб Сложность: 28%)
В современной биологии ученым часто приходится иметь дело с последовательностями ДНК. Эти последовательности зачастую являются очень длинными, и их ручная обработка требует большого количества времени и сил. Поэтому возникает идея автоматизировать этот процесс.

Для этого можно применять компьютерные методы обработки данных, например, весьма полезными оказываются алгоритмы на строках. В этой задаче последовательность ДНК будет представляться в виде непустой строки, все символы которой входят в множество {A, G, С, T}.

Пусть даны две последовательности ДНК: s = s1s2 … sn и t = t1t2 … tm. Будем говорить, что t может получится в результате эволюции из s, если s является подпоследовательностью t, то есть существует такая последовательность индексов 1 ≤ i1 < i2 < … < in ≤ m, что s1=ti1, s2=ti2, … sn=tin. Необходимо выяснить, может ли последовательность t получится в результате эволюции из s.

Входные данные
Первая строка входного файла INPUT.TXT содержит последовательность s, вторая — последовательность t. Размер входного файла не превосходит 256 килобайт.

Выходные данные
В выходной файл OUTPUT.TXT выведите слово YES, если последовательность t могла получиться в результате эволюции из s, и слово NO — иначе.

in:
GTA
AGCTA

out:
YES

in:
AAAG
GAAAAAT

out:
NO
* */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T278 {
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s = reader.readLine().toCharArray();
        char[] t = reader.readLine().toCharArray();
        for(int i = 0, j = 0; i < t.length; i++) {
            if (t[i] == s[j]) {
                ++j;
                if (j == s.length) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
