package com.heavy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavy.entity.Invoice;
import com.heavy.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
	
	@Autowired
	private InvoiceRepository _invoiceRepository;

	@Override
	public List<Invoice> findAll() {
		
		return (List<Invoice>) _invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Integer id) {
		
		return _invoiceRepository.findById(id).orElse(null) ;
	}

	@Override
	public Invoice save(Invoice invoice) {
		
		return _invoiceRepository.save(invoice);
	}

}
