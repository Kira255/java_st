package dz_oop.dz6.Service.impl;

import dz_oop.dz6.Model.Example;
import dz_oop.dz6.Service.Operation;

public class RationalOperationlmpl implements Operation<Number> {
    /**
     * The method finds the sum of rational numbers
     * 
     * @param example contains two values
     * @return sum of numbers
     */
    @Override
    public Number sum(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() + (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() + (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() + (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the divide of rational numbers
     *
     * @param example contains two values
     * @return divide of numbers
     */
    @Override
    public Number divide(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() / (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() / (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() / (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the difference of rational numbers
     *
     * @param example contains two values
     * @return difference of numbers
     */
    @Override
    public Number difference(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() - (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() - (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() - (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the multiplication of rational numbers
     *
     * @param example contains two values
     * @return multiplication nf numbers
     */
    @Override
    public Number multiply(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() * (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() * (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() * (Float) example.getVariableB();
        } else {
            return null;
        }
    }
}
