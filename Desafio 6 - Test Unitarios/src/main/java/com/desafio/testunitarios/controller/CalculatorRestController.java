package com.desafio.testunitarios.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.entity.OperationResultEntity;
import com.desafio.testunitarios.exception.InvalidMathematicalOperationResultException;
import com.desafio.testunitarios.exception.MathematicalOperationNotSupportedException;
import com.desafio.testunitarios.exception.MathematicalOperationNotValidException;
import com.desafio.testunitarios.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorRestController {

    private final CalculatorService calculatorService;

    public CalculatorRestController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public OperationResultEntity doOperation(@RequestBody Operation operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException {
        return this.calculatorService.calculate(operation);
    }

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void validateOperation(@RequestBody OperationResultEntity operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException, InvalidMathematicalOperationResultException {
        this.calculatorService.validate(operation);
    }
    
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResultEntity> listOperations(){
    	return this.calculatorService.listOperations();
    }
    
    
}
