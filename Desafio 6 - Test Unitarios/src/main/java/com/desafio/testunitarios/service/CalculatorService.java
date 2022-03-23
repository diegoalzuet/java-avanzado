package com.desafio.testunitarios.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.Operator;
import com.desafio.testunitarios.domain.entity.OperationResultEntity;
import com.desafio.testunitarios.exception.InvalidMathematicalOperationResultException;
import com.desafio.testunitarios.exception.MathematicalOperationNotSupportedException;
import com.desafio.testunitarios.exception.MathematicalOperationNotValidException;
import com.desafio.testunitarios.repository.OperationResultRepository;

@Service
public class CalculatorService {
	
//	@Autowired
	private OperationResultRepository operationResultRepository;
	
	

    public CalculatorService(OperationResultRepository operationResultRepository) {	
		this.operationResultRepository = operationResultRepository;
	}

	public OperationResultEntity calculate(Operation operation) throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {
        if (Operator.ADD.equals(operation.getOperator())) {
            return operationResultRepository.save(this.add(operation.getLeft(), operation.getRight()));
        } else if (Operator.DIFFERENCE.equals(operation.getOperator())) {
            return operationResultRepository.save(this.difference(operation.getLeft(), operation.getRight()));
        } else if (Operator.MULTIPLY.equals(operation.getOperator())) {
            return operationResultRepository.save(this.multiply(operation.getLeft(), operation.getRight()));
        } else if (Operator.DIVIDE.equals(operation.getOperator())) {
            if (operation.getRight() == 0.0) {
                throw new MathematicalOperationNotValidException("Trying to perform division against 0");
            }
            return operationResultRepository.save(this.divide(operation.getLeft(), operation.getRight()));
        }
        throw new MathematicalOperationNotSupportedException("We only support ADD/DIFFERENCE/MULTIPLY/DIVIDE operations");
    }

    public OperationResultEntity divide(Double left, Double right) {
        return new OperationResultEntity(left, Operator.DIVIDE, right, left / right);
    }

    public OperationResultEntity difference(Double left, Double right) {
        return new OperationResultEntity(left, Operator.DIFFERENCE, right, left - right);
    }

    public OperationResultEntity add(Double left, Double right) {
        return new OperationResultEntity(left, Operator.ADD, right, left + right);
    }

    public OperationResultEntity multiply(Double left, Double right) {
        return new OperationResultEntity(left, Operator.MULTIPLY, right, left * right);
    }

    public void validate(OperationResultEntity operation) throws MathematicalOperationNotSupportedException, MathematicalOperationNotValidException, InvalidMathematicalOperationResultException {
        Operation previousOperation = new Operation(operation.getLeftt(), operation.getOperator(), operation.getRightt());

        Double realResult = this.calculate(previousOperation).getResult();

        if (!operation.getResult().equals(realResult)) {
            throw new InvalidMathematicalOperationResultException(String.format("We were expecting as a result %f, but you gave to us %f", realResult, operation.getResult()));
        }
    }
    
    public List<OperationResultEntity> listOperations(){
    	return (List<OperationResultEntity>) this.operationResultRepository.findAll();
    }
}
