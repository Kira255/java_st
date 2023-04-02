package dz_oop.dz6.Service;

import dz_oop.dz6.Model.Example;

public interface Operation<T> {
    /**
     * The method finds the sum of rational numbers
     *
     * @param example contains two values
     * @return sum of numbers
     */
    T sum(Example<T> example);

    /**
     * The method finds the divide of rational numbers
     *
     * @param example contains two values
     * @return divide of numbers
     */
    T divide(Example<T> example);

    /**
     * The method finds the difference of rational numbers
     *
     * @param example contains two values
     * @return difference of numbers
     */
    T difference(Example<T> example);

    /**
     * The method finds the multiplication of rational numbers
     *
     * @param example contains two values
     * @return difference of numbers
     */
    T multiply(Example<T> example);
}
