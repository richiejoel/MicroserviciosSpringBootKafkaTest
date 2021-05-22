package com.heavy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.heavy.entity.Invoice;
import com.heavy.service.IInvoiceService;

@RestController
public class InvoiceController {
	
	@Autowired
	private IInvoiceService service;
	
	@GetMapping("findAll")
	public List<Invoice> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Invoice findOne(@PathVariable Integer id) {
		Invoice invoice = service.findById(id);
		return invoice;
	}

}
