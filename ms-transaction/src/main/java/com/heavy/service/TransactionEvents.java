package com.heavy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heavy.entity.Transaction;

@Service
public class TransactionEvents {
	
	@Autowired
	private ITransactionService service;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent : {}", event.getIdOperation());
		
		String destructurar = consumerRecord.value();
		String [] parts = destructurar.split("\"dataTime\":\"");
		String fechaString = parts[1].toString().replaceFirst("[\\s\\S]{0,2}$", "");
		log.info("Fecha consumerRecord -> " + fechaString);
		try {
			Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(fechaString);
			event.setDateTime(dateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		log.info("Fecha : {}", event.getDateTime() );
		service.save(event);
	}

}
