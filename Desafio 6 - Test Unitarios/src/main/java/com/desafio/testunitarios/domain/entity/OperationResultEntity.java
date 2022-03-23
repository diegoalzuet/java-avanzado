package com.desafio.testunitarios.domain.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.testunitarios.domain.Operator;

@Entity
@Table(name = "operation_result")
public class OperationResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double leftt;

    @Enumerated(EnumType.ORDINAL)
    private Operator operator;

    private Double rightt;

    private Double result;

	public OperationResultEntity(Double left, Operator operator, Double right, Double result) {
		super();		
		this.leftt = left;
		this.operator = operator;
		this.rightt = right;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Double getRightt() {
		return rightt;
	}

	public void setRightt(Double right) {
		this.rightt = right;
	}

	public Double getResult() {
		return result;
	}

	public Double getLeftt() {
		return leftt;
	}

	public void setLeftt(Double leftt) {
		this.leftt = leftt;
	}    
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResultEntity that = (OperationResultEntity) o;
        return Objects.equals(leftt, that.leftt) && operator == that.operator && Objects.equals(rightt, that.rightt) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftt, operator, rightt, result);
    }
    
}
