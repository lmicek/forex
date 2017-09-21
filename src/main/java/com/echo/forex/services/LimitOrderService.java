package com.echo.forex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.LimitOrder;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.LimitOrderRepo;

@Service(value="limitOrderService")
public class LimitOrderService {

	private LimitOrderRepo limitOrderMart;
	
	@Autowired
	public LimitOrderService(LimitOrderRepo lmOrdRef) {
		this.limitOrderMart = lmOrdRef;
	}
	
	public List<LimitOrder> getAllLimitOrdersByTransactionType(Transaction transactionType) {
		return this.limitOrderMart.findByTransactionType(transactionType);
	}
	
	public List<LimitOrder> getAllLimitOrders() {
		return (List<LimitOrder>) this.limitOrderMart.findAll();
	}
	
	public List<LimitOrder> getAllCompletedLimitOrders() {
		return (List<LimitOrder>) this.limitOrderMart.findByIsCompleted(true);
	}
	
	public List<LimitOrder> getAllInCompleteLimitOrders() {
		return (List<LimitOrder>) this.limitOrderMart.findByIsCompleted(false);
	}
	
	public List<LimitOrder> getAllLimitOrdersByCurrencyPair(CurrencyPairs currencypair) {
		return (List<LimitOrder>) this.limitOrderMart.findByLimitOrderCurrPair(currencypair);
	}
	
	public LimitOrder getLimitOrderById(long id) {
		
		List<LimitOrder> limitOrderList = (List<LimitOrder>) this.limitOrderMart.findById(id);
		return limitOrderList.get(0); 
	}
	
	public long addNewLimitOrder(LimitOrder lmOrder){
		this.limitOrderMart.save(lmOrder);
		return lmOrder.getId();
	}
	
	
}
