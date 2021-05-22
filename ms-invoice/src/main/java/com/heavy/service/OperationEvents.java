package com.heavy.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heavy.entity.Invoice;
import com.heavy.entity.Operation;

@Service
public class OperationEvents {
	
	private static final String NO_PAGADA = "NO-PAGADA";
	private static final String PAGADA = "PAGADA";
	
	@Autowired
	private IInvoiceService invoiceService;
	@Autowired
	private ObjectMapper objectMapper;
	
	private Logger log = LoggerFactory.getLogger(OperationEvents.class);
	
	
	public void processOperationEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		Invoice invoice = new Invoice();
		Operation event = objectMapper.readValue(consumerRecord.value(), Operation.class);
		invoice = invoiceService.findById(event.getIdInvoice());
		double amountResult = 0.0;
		
		if(event.getAmount() >= invoice.getAmount()) {
			invoice.setState(PAGADA);
		} else {
			invoice.setState(NO_PAGADA);
		}
		amountResult = invoice.getAmount() - event.getAmount();
		if(amountResult < 0) {
			amountResult = 0.0;
		}
		
		invoice.setAmount(amountResult);
		log.info("Actualizando el N# de factura ***"+event.getIdInvoice());
		invoiceService.save(invoice);
		
	}

}
