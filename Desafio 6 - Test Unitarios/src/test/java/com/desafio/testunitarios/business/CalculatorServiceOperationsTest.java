package com.desafio.testunitarios.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.Operator;
import com.desafio.testunitarios.domain.entity.OperationResultEntity;
import com.desafio.testunitarios.exception.MathematicalOperationNotSupportedException;
import com.desafio.testunitarios.exception.MathematicalOperationNotValidException;
import com.desafio.testunitarios.repository.OperationResultRepository;
import com.desafio.testunitarios.service.CalculatorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalculatorServiceOperationsTest {

	@Mock
	private OperationResultRepository repository;	
	private CalculatorService calculatorService;
	
	@BeforeEach
	void setUp() {		
		calculatorService = new CalculatorService(repository);
	}
	

	@Test
	void testCalculate_ShouldReturnOperationResult_WithAddOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		
		Operation incoming = new Operation(10.0, Operator.ADD, 30.0);

		OperationResultEntity expected = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.0);

		OperationResultEntity result = calculatorService.add(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);		
	}
	
	@Test
	void testCalculate_ShouldReturnOperationResult_WithDifferenceOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		
		Operation incoming = new Operation(50.0, Operator.DIFFERENCE, 30.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.DIFFERENCE, 30.0, 20.0);

		OperationResultEntity result = calculatorService.difference(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);		
	}
	
	@Test
	void testCalculate_ShouldReturnOperationResult_WithMultiplyOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		
		Operation incoming = new Operation(50.0, Operator.MULTIPLY, 30.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.MULTIPLY, 30.0, 1500.0);

		OperationResultEntity result = calculatorService.multiply(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);		
	}
	@Test
	void testCalculate_ShouldReturnOperationResult_WithDivideOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		
		Operation incoming = new Operation(50.0, Operator.DIVIDE, 2.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.DIVIDE, 2.0, 25.0);

		OperationResultEntity result = calculatorService.divide(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);		
	}
	@Test
	void test_ListOperations() {
		calculatorService.listOperations();
		verify(repository).findAll();
		
	}
	
	
	
}