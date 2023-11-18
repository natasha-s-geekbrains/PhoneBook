import java.util.*;

class PhoneBook {

    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(phoneNum);
            phoneBook.put(name, values);
        }
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return new ArrayList<Integer>();
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    // ниже попытки создать нужные методы в этом классе

//
//    public  HashMap<String, Integer> getNumQty(PhoneBook phoneBook) {
//        HashMap<String, Integer> numQty = new HashMap<>();
//        for (Object o: phoneBook.entrySet()) {
//            String name = o.getKey();
//            ArrayList<Integer> list = o.getValue();
//            Integer qty = list.size();
//            numQty.put(name, qty);
//        }
//        return numQty;
//    }
//
//    private  Object entrySet() {
//        return phoneBook.entrySet();
//    }
//
//    public static LinkedHashMap<String, Integer> getSortedHM(PhoneBook phoneBook) {
//        LinkedHashMap<String, Integer> sortedHM = new LinkedHashMap<>();
//        phoneBook.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEach(e -> sortedHM.put(e.getKey(), e.getValue()));
//        return sortedHM;
//    }
//
//    public static LinkedHashMap<String, ArrayList<Integer>> getSortedPhBook(
//            LinkedHashMap<String, Integer> x,
//            PhoneBook phoneBook ){
//        LinkedHashMap<String, ArrayList<Integer>> resHM = new LinkedHashMap<>();
//        for (var item : x.entrySet()){
//            String name = item.getKey();
//            ArrayList<Integer> list = phoneBook.get(name);
//            resHM.put(name, list);
//        }
//        return resHM;
//    }
//
//    private ArrayList<Integer> get(Map.Entry me, String s) {
//        return me get(me s);
//    }


}




