package dz_oop.dz4;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<E extends Number> implements Simple<E> {

    private E[] values;
    private int size;

    public SimpleArray() {
        this.values = (E[]) new Number[10];
        this.size = 0;
    }

    public SimpleArray(E[] data) {
        this.values = (E[]) new Number[data.length];
        for (int i = 0; i < data.length; i++) {
            this.values[i] = data[i];
        }
        this.size = data.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Number[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Number[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int countElAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, countElAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePos(E item) {
        int pos = index(item);

        if (pos < 0) {
            return;
        }
        delete(pos);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;

    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public int index(E e) {
        if (e == null)
            return -1;
        for (int i = 0; i < values.length; i++) {
            if (e.equals(values[i]))
                return i;

        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(values, values.length));
    }

    @Override
    public void display() {
        for (E el : values) {
            System.out.println(el + " ");
        }
    }

    @Override
    public int min() {
        int mini = (int) values[0];
        for (E el : values) {
            if (mini > (int) el) {
                mini = (int) el;
            }
        }
        return mini;
    }

    @Override
    public int max() {
        int maxi = (int) (values[0]);
        for (E el : values) {
            if (maxi < (int) el) {
                maxi = (int) el;
            }
        }
        return maxi;
    }

    @Override
    public E sum() {
        E sum = null;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sum = values[i];
            } else {
                sum = (E) new Double(sum.doubleValue() + values[i].doubleValue());
            }
        }
        return sum;
    }

    @Override
    public E mul() {
        E mul = null;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                mul = values[i];
            } else {
                mul = (E) new Double(mul.doubleValue() * values[i].doubleValue());
            }
        }
        return mul;
    }

    @Override
    public boolean inArray(E e) {
        for (E el : values) {
            if (e == el) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void bubbleSort() {
        boolean isSorted = false;
        E buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < values.length - 1; i++) {
                if ((int) values[i] > (int) values[i + 1]) {
                    isSorted = false;

                    buf = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = buf;
                }
            }
        }
    }

    @Override
    public void inserionSort() {
        for (int i = 1; i < values.length; i++) {
            E current = values[i];
            int j = i - 1;
            while (j >= 0 && (int) current < (int) values[j]) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = current;
        }
    }

    @Override
    public void selectionSort() {
        for (int i = 0; i < values.length; i++) {
            E min = values[i];
            int minId = i;
            for (int j = i + 1; j < values.length; j++) {
                if ((int) values[j] < (int) min) {
                    min = values[j];
                    minId = j;
                }
            }
            E temp = values[i];
            values[i] = min;
            values[minId] = temp;
        }
    }

}
