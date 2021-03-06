package com.heavy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavy.entity.Transaction;
import com.heavy.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private TransactionRepository _repository;

	@Override
	public Transaction save(Transaction transaction) {
		return _repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByIdInvoice(Integer idInvoice) {
		return _repository.findByIdInvoice(idInvoice);
	}

	@Override
	public Iterable<Transaction> findAll() {
		return _repository.findAll();
	}

}
