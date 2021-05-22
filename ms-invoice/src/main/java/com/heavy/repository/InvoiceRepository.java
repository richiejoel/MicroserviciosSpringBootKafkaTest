package com.heavy.repository;

import org.springframework.data.repository.CrudRepository;

import com.heavy.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

}
