package com.desafio.testunitarios.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;
import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.Operator;
import com.desafio.testunitarios.domain.entity.OperationResultEntity;
import com.desafio.testunitarios.exception.InvalidMathematicalOperationResultException;
import com.desafio.testunitarios.exception.MathematicalOperationNotSupportedException;
import com.desafio.testunitarios.exception.MathematicalOperationNotValidException;
import com.desafio.testunitarios.repository.OperationResultRepository;
import com.desafio.testunitarios.service.CalculatorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalculatorServiceOperationsTest {

	@Mock
	private OperationResultRepository repository;
	private CalculatorService calculatorService;
	
	@Spy
	@InjectMocks
	private CalculatorService serviceMock;

	@BeforeEach
	void setUp() {
		calculatorService = new CalculatorService(repository);
	}

	@Test
	@Disabled
	void testCalculate_ShouldReturnOperationResult_WithAddOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

		Operation incoming = new Operation(10.0, Operator.ADD, 30.0);

		OperationResultEntity expected = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.0);

		OperationResultEntity result = calculatorService.add(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Disabled
	void testCalculate_ShouldReturnOperationResult_WithDifferenceOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

		Operation incoming = new Operation(50.0, Operator.DIFFERENCE, 30.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.DIFFERENCE, 30.0, 20.0);

		OperationResultEntity result = calculatorService.difference(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Disabled
	void testCalculate_ShouldReturnOperationResult_WithMultiplyOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

		Operation incoming = new Operation(50.0, Operator.MULTIPLY, 30.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.MULTIPLY, 30.0, 1500.0);

		OperationResultEntity result = calculatorService.multiply(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@Disabled
	void testCalculate_ShouldReturnOperationResult_WithDivideOperator()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

		Operation incoming = new Operation(50.0, Operator.DIVIDE, 2.0);

		OperationResultEntity expected = new OperationResultEntity(50.0, Operator.DIVIDE, 2.0, 25.0);

		OperationResultEntity result = calculatorService.divide(incoming.getLeft(), incoming.getRight());

		assertThat(result).isEqualTo(expected);
	}

	@Test
	void testCalculate_ShouldThrowMathematicalOperationNotValidException_WhenTryingToDivideByZero() {

		Operation incoming = new Operation(10.0, Operator.DIVIDE, 0.0);

		assertThrows(MathematicalOperationNotValidException.class, () -> calculatorService.calculate(incoming));
	}

	@Test
	void test_ListOperations() {
		calculatorService.listOperations();
		verify(repository).findAll();

	}

	@Test
	void test_CalculateMultiply()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		Operation incoming = new Operation(50.0, Operator.MULTIPLY, 2.0);

		calculatorService.calculate(incoming);

		ArgumentCaptor<OperationResultEntity> operationResultEntityArgument = ArgumentCaptor
				.forClass(OperationResultEntity.class);

		verify(repository).save(operationResultEntityArgument.capture());

		OperationResultEntity operationResult = operationResultEntityArgument.getValue();

		assertThat(operationResult).isEqualTo(calculatorService.multiply(incoming.getLeft(), incoming.getRight()));
	}

	@Test
	void test_CalculateDivide()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		Operation incoming = new Operation(50.0, Operator.DIVIDE, 2.0);

		calculatorService.calculate(incoming);

		ArgumentCaptor<OperationResultEntity> operationResultEntityArgument = ArgumentCaptor
				.forClass(OperationResultEntity.class);

		verify(repository).save(operationResultEntityArgument.capture());

		OperationResultEntity operationResult = operationResultEntityArgument.getValue();

		assertThat(operationResult).isEqualTo(calculatorService.divide(incoming.getLeft(), incoming.getRight()));
	}

	@Test
	void test_CalculateAdd() throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		Operation incoming = new Operation(50.0, Operator.ADD, 2.0);

		calculatorService.calculate(incoming);

		ArgumentCaptor<OperationResultEntity> operationResultEntityArgument = ArgumentCaptor
				.forClass(OperationResultEntity.class);

		verify(repository).save(operationResultEntityArgument.capture());

		OperationResultEntity operationResult = operationResultEntityArgument.getValue();

		assertThat(operationResult).isEqualTo(calculatorService.add(incoming.getLeft(), incoming.getRight()));
	}

	@Test
	void test_CalculateDifference()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
		Operation incoming = new Operation(50.0, Operator.DIFFERENCE, 2.0);

		calculatorService.calculate(incoming);

		ArgumentCaptor<OperationResultEntity> operationResultEntityArgument = ArgumentCaptor
				.forClass(OperationResultEntity.class);

		verify(repository).save(operationResultEntityArgument.capture());

		OperationResultEntity operationResult = operationResultEntityArgument.getValue();

		assertThat(operationResult).isEqualTo(calculatorService.difference(incoming.getLeft(), incoming.getRight()));
	}

	@Test
	void test_CalculateInvalid()
			throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

		Operation incoming = new Operation(50.0, Operator.POW, 2.0);

		assertThrows(MathematicalOperationNotSupportedException.class, () -> calculatorService.calculate(incoming));

	}

	@Test
	void test_validate() throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException,
			InvalidMathematicalOperationResultException {

		
		OperationResultEntity incoming = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.0);
		Operation incomingOperation = new Operation(10.0, Operator.ADD, 30.0);
		OperationResultEntity result = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.0);
		
		doReturn(result).when(this.serviceMock).calculate(incomingOperation);		
		
		serviceMock.validate(incoming);
		verify(serviceMock,times(1)).validate(incoming);

	}
	
	@Test
	void test_validateThrowInvalidMathematicalOperationResultException() throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException,
			InvalidMathematicalOperationResultException {
		
		OperationResultEntity incoming = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.0);
		Operation incomingOperation = new Operation(10.0, Operator.ADD, 30.0);
		OperationResultEntity result = new OperationResultEntity(10.0, Operator.ADD, 30.0, 40.1);
		
		doReturn(result).when(this.serviceMock).calculate(incomingOperation);
		
		assertThrows(InvalidMathematicalOperationResultException.class, () -> serviceMock.validate(incoming));	

	}

}