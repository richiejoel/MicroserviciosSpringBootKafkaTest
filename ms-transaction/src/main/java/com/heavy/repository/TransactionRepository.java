package com.heavy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heavy.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>  {
	
	@Query("{'id_invoice':?0}")
	public Iterable<Transaction> findByIdInvoice(Integer idInvoice);
}
