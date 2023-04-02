package dz_oop.dz6.Model;

import dz_oop.dz6.Model.enums.OperationType;

public abstract class Example<T> {
    private T variableA;
    private T variableB;
    private final OperationType operation;

    public Example(OperationType operation) {
        this.operation = operation;
    }

    public T getVariableA() {
        return variableA;
    }

    public void setVariableA(T variableA) {
        this.variableA = variableA;
    }

    public T getVariableB() {
        return variableB;
    }

    public void setVariableB(T variableB) {
        this.variableB = variableB;
    }

    public OperationType getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "varA=" + variableA + "; varB=" + variableB + "operation" + operation;
    }
}
