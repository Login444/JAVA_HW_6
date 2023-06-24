package org.example;


import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        // Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
        List<Workers> list = new ArrayList<>();
        list = listCollection();
        HashMap<String, Integer> mapWorkers = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!mapWorkers.containsKey(list.get(i).getName())){
                mapWorkers.put(list.get(i).getName(), 1);
            } else if (mapWorkers.containsKey(list.get(i).getName())) {
                mapWorkers.put(list.get(i).getName(), mapWorkers.get(list.get(i).getName() + 1));
            }
        }
        sortByValue(mapWorkers);
    }

    private static void sortByValue(HashMap<String, Integer> mapWorkers) {
        ArrayList<LinkedList> arrayList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < mapWorkers.size(); i++) {
            for (Integer value : mapWorkers.values()) {
                if (value>max){
                    max = value;
                }
            }

        }
    }

    private static Workers setCollection(){
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String lastname = scan.nextLine();
        Workers worker = new Workers(name, lastname);
        scan.close();
        return worker;
    }

    private static List<Workers> listCollection(){
        List<Workers> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println((i+1) + "-й сотрудник: ");
            list.add(setCollection());
        }
        return list;
    }
}
