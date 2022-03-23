package com.desafio.testunitarios;



import org.junit.jupiter.api.Test;

import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.Operator;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    void testOperation_ShouldReturnNewInstance() {

        Double right = 33.0;
        Double left = 30.0;
        Operator operator = Operator.ADD;

        Operation operation = new Operation(left, operator, right);

        assertThat(operation).isEqualTo(operation);
    }
}