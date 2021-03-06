package com.heavy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.heavy.entity.Transaction;
import com.heavy.service.ITransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	ITransactionService _transaction;	
	
	@GetMapping("findAll")	
	public List<Transaction> findAll (){
		return ( List<Transaction>)_transaction.findAll();
	}
	
	@GetMapping ("/transaction/{idInvoice}")
	public ResponseEntity<?> getByAccountId (@PathVariable Integer idInvoice){
		Iterable< Transaction> transaction= _transaction.findByIdInvoice(idInvoice);
		return ResponseEntity.ok(transaction);
	}	

}
