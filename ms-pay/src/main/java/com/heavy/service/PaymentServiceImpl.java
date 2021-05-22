package com.heavy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavy.dao.IPaymentDao;
import com.heavy.domain.Operation;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private IPaymentDao _paymentDao;

	@Override
	@Transactional
	public Operation save(Operation operation) {
		return _paymentDao.save(operation);
	}

}
