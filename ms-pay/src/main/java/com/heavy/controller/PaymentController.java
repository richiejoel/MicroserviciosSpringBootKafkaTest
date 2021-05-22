package com.heavy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heavy.domain.Operation;
import com.heavy.producer.PaymentEventProducer;
import com.heavy.service.IPaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private IPaymentService service;
	@Autowired
	private PaymentEventProducer eventProducer;
	
	private Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/v1/payment")
	public ResponseEntity<Operation> postDepositEvent(@RequestBody Operation operation) throws JsonProcessingException {
		
		Operation transql = service.save(operation);
		eventProducer.sendPaymentEvent(transql);
		log.info("despues de sendDepositEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}

}
