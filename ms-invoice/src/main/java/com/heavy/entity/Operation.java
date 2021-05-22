package com.heavy.entity;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {

	private static final long serialVersionUID = 9147545554107260997L;
	
	private Integer idOperation;
	private Integer idInvoice;
	private double amount;
	private Date dataTime;
	
	public Integer getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}
	public Integer getIdInvoice() {
		return idInvoice;
	}
	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDataTime() {
		return dataTime;
	}
	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}
	
	

}
