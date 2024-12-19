package intensiveHW1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;


/**
 * Класс ArrayList_NikitaDoronin
 * @author Доронин Никита
 * @version 1.0
 */
public class ArrayList_NikitaDoronin<E> implements IntensiveList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * Конструктор по умолчанию.
     */
    public ArrayList_NikitaDoronin() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор, задающий размер списка.
     * @param initialCapacity - размер
     */
    public ArrayList_NikitaDoronin(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Конструктор, создающий список на основе переданной коллекции.
     *
     * @param collection коллекия, элементы которой будут переданы в список
     *
     */

    public ArrayList_NikitaDoronin(Collection<? extends E> collection) {
        elements = collection.toArray();
        size = elements.length;
    }



    /** Метод, возвращающий размер списка.
     * @return - значение типа int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод, позволяющий добавить в список значение типа, указанного при инициализации.
     * @param element  данные для добавления
     */
    @Override
    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Метод, позволяющий добавить в список значение по индексу.
     * @param index - индекс добавляемой позиции
     * @param element - данные для добавления
     */
    @Override
    public void add(int index, E element) {
        validateIndexForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Метод, позволяющий получить данные из списка по индексу.
     * @param index - индекс запрашиваемой позиции
     * @return - значение типа, указанного при инициализации списка.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        validateIndex(index);
        return (E) elements[index];
    }

    /**
     * Метод, позволяющий заменить в списке значение типа, указанного при инициализации,
     * на новое, хранимое по определённому индексу.
     * @param index - индекс заменяемой позиции
     * @param element - новые данные для добавления
     * @return - значение типа, указанного при инициализации списка.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * Метод, позволяющий удалить данные из списка по индексу.
     * @param index - индекс удаляемой позиции
     * @return - значение типа, указанного при инициализации списка (удаляемая позиция).
     */
    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        validateIndex(index);
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear obsolete reference
        return removedElement;
    }

    /**
     * Метод, позволяющий удалить данные из списка и вернуть его размер по умолчанию.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Метод, реализующий быструю сортировку списка по заданному компаратору.
     * Запускает механизм сортировки.
     * @param comparator - передаваемый компаратор.
     */
    @Override
    public void quickSort(Comparator<E> comparator) {
        quickSort(comparator, 0, size - 1);
    }

    private void quickSort(Comparator<E> comparator, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(comparator, low, high);
            quickSort(comparator, low, pivotIndex - 1);
            quickSort(comparator, pivotIndex + 1, high);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(Comparator<E> comparator, int low, int high) {
        E pivot = (E) elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare((E) elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Метод, позволяющий узнать является ли список отсортированным.
     * @return - значение булевого типа.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isSorted() {
        for (int i = 0; i < size - 1; i++) {
            if (((Comparable<E>) elements[i]).compareTo((E) elements[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, позволяющий сократить размер списка с потерей данных, хранимых в позициях с индексом выше переданного.
     */
    @Override
    public void split(int newSize) {
        if (newSize < 0 || newSize > size) {
            throw new IllegalArgumentException("Invalid size: " + newSize);
        }
        for (int i = newSize; i < size; i++) {
            elements[i] = null;
        }
        size = newSize;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length + (elements.length >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
