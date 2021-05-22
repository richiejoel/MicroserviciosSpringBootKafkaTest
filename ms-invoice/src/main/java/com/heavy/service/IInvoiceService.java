package com.heavy.service;

import java.util.List;

import com.heavy.entity.Invoice;

public interface IInvoiceService {
	
	public List<Invoice> findAll();
	
	public Invoice findById(Integer id);
	
	public Invoice save (Invoice invoice);

}
