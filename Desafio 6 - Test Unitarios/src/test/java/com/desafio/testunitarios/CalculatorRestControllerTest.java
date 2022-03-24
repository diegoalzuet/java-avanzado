package com.desafio.testunitarios;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafio.testunitarios.controller.CalculatorRestController;
import com.desafio.testunitarios.domain.entity.OperationResultEntity;
import com.desafio.testunitarios.exception.InvalidMathematicalOperationResultException;
import com.desafio.testunitarios.exception.MathematicalOperationNotSupportedException;
import com.desafio.testunitarios.exception.MathematicalOperationNotValidException;
import com.desafio.testunitarios.service.CalculatorService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorRestControllerTest {

	@InjectMocks
	CalculatorRestController calculatorRestController;

	@Mock
	CalculatorService calculatorService;

	@Test
	void testValidateOperation_ShouldDoNothing_WhenCallingServiceFunction()
			throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException,
			InvalidMathematicalOperationResultException {

		OperationResultEntity operationResult = mock(OperationResultEntity.class);		

		doNothing().when(this.calculatorService).validate(operationResult);		

		this.calculatorRestController.validateOperation(operationResult);

		verify(this.calculatorService, times(1)).validate(operationResult);
	}
	
	@Test
	void testListOperations_ShouldDoNothing_WhenCallingServiceFunction()
			throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException,
			InvalidMathematicalOperationResultException {
	
		this.calculatorRestController.listOperations();

		verify(this.calculatorService, times(1)).listOperations();
	}
}