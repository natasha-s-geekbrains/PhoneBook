import java.util.*;

public class Main {
    public static void main(String[] args) {

//    Реализуйте структуру телефонной книги с помощью HashMap.
//    Программа также должна учитывать, что в во входной структуре
//    будут повторяющиеся имена с разными телефонами, их необходимо считать,
//    как одного человека с разными телефонами.
//    Вывод должен быть отсортирован по убыванию числа телефонов.

        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println("***Начало домашнего задания к семинару №5***");
        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
        System.out.println("Класс создан и методы работают.\n***Конец домашнего задания к семинару №5.***");
        System.out.println();
        System.out.println("***Начало домашнего задания к семинару №6***");

        // теперь к созданной выше тел.книге не получается применить обычные методы,
        // так как тел.книга относится к классу Phonebook и к нему нужно пересоздавать методы,
        // но их тоже не получилось создать. Поэтому пришлось создать новую тел.книгу без помощи класса Phonebook:
        // создаю абонентов
        String k = "Kuznetsov";
        String i = "Ivanov";
        String p = "Petrov";
        String s = "Sidorov";

        // Создаю списки телефонов
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        a.add(1111111);
        a.add(2222222);
        a.add(3333333);
        b.add(123456);
        b.add(654321);
        c.add(2223322);
        d.add(9999999);

        // присваиваю абонентам возданные списки телефонов
        HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        phoneBook.put(k, a);
        phoneBook.put(i, b);
        phoneBook.put(p, c);
        phoneBook.put(s, d);


        // вывожу получившуюся телефонную книгу
        System.out.println("Начальная телефонная книга:");
        System.out.println(phoneBook);
        // вывожу отсортированную телефонную книгу
        System.out.println("Отсортированная телефонная книга:");
        System.out.println(getSortedPhBook(getSortedHM(getNumQty(phoneBook)), phoneBook));

    }


    public static HashMap<String, Integer> getNumQty(HashMap<String, ArrayList<Integer>> hm) {
        // метод получает кол-во тел.номеров у абонентов в формате HashMap<String, Integer>
        HashMap<String, Integer> numQty = new HashMap<>();
        for (var item : hm.entrySet()) {
            String name = item.getKey();
            ArrayList<Integer> list = item.getValue();
            Integer qty = list.size();
            numQty.put(name, qty);
        }
        return numQty;
    }

    public static LinkedHashMap<String, Integer> getSortedHM(HashMap<String, Integer> hm) {
        // метод сортирует список абонентов по кол-ву у них тел.номеров
        LinkedHashMap<String, Integer> sortedHM = new LinkedHashMap<>();
        hm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> sortedHM.put(e.getKey(), e.getValue()));
        return sortedHM;
    }

    public static LinkedHashMap<String, ArrayList<Integer>> getSortedPhBook(
            LinkedHashMap<String, Integer> x,
            HashMap<String, ArrayList<Integer>> y ){
        // метод собирает отсортированную тел.книгу по кол-ву номеров у абонентов
        LinkedHashMap<String, ArrayList<Integer>> resHM = new LinkedHashMap<>();
        for (var item : x.entrySet()){
            String name = item.getKey();
            ArrayList<Integer> list = y.get(name);
            resHM.put(name, list);
        }
    return resHM;
    }

}