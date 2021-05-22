package com.heavy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = -283789854534944980L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_invoice")
	private Integer idInvoice;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "state")
	private String state;
	
	public Integer getIdInvoice() {
		return idInvoice;
	}
	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
