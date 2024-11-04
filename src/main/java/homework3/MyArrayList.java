package homework3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T>  {
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        final int DEFAULT_CAPACITY = 10;
        elements =  new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> c) {
        elements = new Object[c.size()];
        addAll(c);
    }

    public Number sum() {
        if (size == 0 || !(elements[0] instanceof Number)) {
            return null;
        }

        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += ((Number) elements[i]).doubleValue();
        }
        return sum;
    }
    public int size() {
        return size;
    }

    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> current = (Comparable<T>) elements[j];
                if (current.compareTo((T) elements[j + 1]) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <T extends Comparable<? super T>> void sort(MyArrayList<T> list) {
        boolean swapped;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }


    public void set(int index, T element) {
        ensureCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;

    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }





    public void printElements(){
        for(Object element : elements)
            if(element != null)
                System.out.print(element + " ");
        System.out.println();
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }
}
