package com.heavy.entity;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "transaction")
public class Transaction {
	
	@BsonId
	@Field("id_transaction")
	private String idOperation;
	@Field("id_invoice")
	private Integer idInvoice;
	@Field("amount")
	private Double amount;
	@DateTimeFormat(style = "M-") 
	@CreatedDate
	@Field("dateTime")
	private Date dateTime;
	
	public String getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}
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
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	

}
