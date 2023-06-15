package ss10_dsa_danh_sach;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);

        }
        return (E) elements[index];

    }

    private void ensureCapa() {
        int newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (elements.length == size) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public int getSize() {
        return size;
    }

    public int indexOf(E e) {
        for (int i = 0; i < elements.length; i++) {
            if (e == elements[i]) {
                return i;
            }
        }
        return -1;
    }


}
