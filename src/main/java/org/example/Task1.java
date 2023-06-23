package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    // Подсчитать количество искомого слова, через map
    // (наполнением значение, где искомое слово будет являться ключом),
    // вносить все слова не нужно
    public static void main(String[] args) {
        Map<String, Integer> mapStr = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = scan.nextLine();
        string.toLowerCase();
        string = string.replaceAll("\\p{Punct}", " ");
        String[] strArr = string.split("\\s");
        findWord(mapStr, scan, strArr);
    }

    private static void findWord(Map<String, Integer> mapStr, Scanner scan, String[] strArr) {
        System.out.println("Введите искомое слово: ");
        String word = scan.nextLine();
        word.toLowerCase();
        mapStr.put(word, 0);
        for (int i = 0; i < strArr.length; i++) {
            if (mapStr.containsKey(strArr[i])){
                mapStr.put(word, mapStr.get(word)+1);
            }
        }
        for (Map.Entry<String, Integer> entry: mapStr.entrySet()) {
            System.out.println("Слово" + entry.getKey() + " встречается " + entry.getValue());
        }
    }
}
