package com.heavy.service;

import com.heavy.entity.Transaction;

public interface ITransactionService {
	
	public Transaction save (Transaction transaction);
	public Iterable<Transaction> findByIdInvoice (Integer idInvoice);
	public Iterable <Transaction> findAll();

}
