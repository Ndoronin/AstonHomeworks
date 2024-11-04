package homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(Arrays.asList(1,23,1234,12,3));
        arrayList.printElements();
        arrayList.sort();
        arrayList.printElements();
        MyArrayList.sort(arrayList);
        System.out.println(arrayList.sum());
    }
}
