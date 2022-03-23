package com.desafio.testunitarios.domain;

import java.util.Objects;

public class Operation {

    private Double left;

    private Operator operator;

    private Double right;

    public Operation() {
    }

    public Operation(Double left, Operator operator, Double right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(left, operation.left) && operator == operation.operator && Objects.equals(right, operation.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, operator, right);
    }
}
