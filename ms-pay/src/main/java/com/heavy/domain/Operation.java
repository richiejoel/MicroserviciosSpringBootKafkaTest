package com.heavy.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay")
public class Operation implements Serializable {

	private static final long serialVersionUID = 8332231462213127681L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_operation")
	private Integer idOperation;
	@Column(name = "id_invoice")
	private Integer idInvoice;
	@Column(name = "amount")
	private double amount;
	@Column(name = "datatime")
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
