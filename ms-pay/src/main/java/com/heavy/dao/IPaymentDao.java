package com.heavy.dao;

import org.springframework.data.repository.CrudRepository;

import com.heavy.domain.Operation;

public interface IPaymentDao extends CrudRepository<Operation, Integer> {

}
