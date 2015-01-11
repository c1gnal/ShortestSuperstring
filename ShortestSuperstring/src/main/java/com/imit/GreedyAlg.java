package com.imit;

import java.util.List;

/**
 * Created by Pretty_Visitor on 11.01.2015.
 */
public class GreedyAlg {
    /*
      * Функция вычисляет максимальную длину суффикса строки s1
      * совпадающего с префиксом строки s2 (длину наложения s1 на s2)
      */
    private static int overlap(String s1, String s2)
    {
        int s1last = s1.length() - 1;
        int s2len = s2.length();
        int overlap = 0;
        for (int i = s1last, j = 1; i > 0 && j < s2len; i--, j++)
        {
            String suff = s1.substring(i);
            String pref = s2.substring(0, j);
            if (suff.equals(pref)) overlap = j;
        }
        return overlap;
    }
    /*
      * Функция сливает строки s1 и s2 на длину len, вычисленную с
      * помощью функции overlap(s1, s2)
      */
    private static String merge(String s1, String s2, int len)
    {
        s2 = s2.substring(len);
        return s1 + s2;
    }
    /*
      * Функция сливает строки с максимальным наложением до тех пор,
      * пока не останется единственная строка (общая надстрока).
      */
    public static String createSuperString(List<String> strings)
    {
        while (strings.size() > 1)
        {
            int maxoverlap = 0;
            String msi = strings.get(0), msj = strings.get(1);
            for (String si : strings)
                for (String sj : strings)
                {
                    if (si.equals(sj)) continue;
                    int curoverlap = overlap(si, sj);
                    if (curoverlap > maxoverlap)
                    {
                        maxoverlap = curoverlap;
                        msi = si; msj = sj;
                    }
                }

            strings.add(merge(msi, msj, maxoverlap));
            strings.remove(msi);
            strings.remove(msj);
        }
        return strings.get(0);
    }
}
