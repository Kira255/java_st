package dz_oop.dz4;

public interface Simple<E> extends Iterable<E> {
    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

    int index(E e);

    void deletePos(E e);

    void display();

    int min();

    int max();

    E sum();

    E mul();

    boolean inArray(E e);

    void bubbleSort();

    void inserionSort();

    void selectionSort();
}
