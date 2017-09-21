package com.echo.forex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.LimitOrder;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.LimitOrderRepo;

@Service
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
	
	public List<LimitOrder> getAllLimitOrdersByCurrencyPair(CurrencyPairs currency) {
		return (List<LimitOrder>) this.limitOrderMart.findByCurrencyPair(currency);
	}
	
	public LimitOrder getLimitOrderById(long id) {
		return (LimitOrder) this.limitOrderMart.findById(id);
	}
	
	public long addNewLimitOrder(LimitOrder lmOrder){
		this.limitOrderMart.save(lmOrder);
		return lmOrder.getId();
	}
	
	/*public String cancelLimitOrderById(long id) {
		LimitOrder changeLmtOrder = getLimitOrderById(id);
		if(changeLmtOrder.getOrderState() == OrderStatus.Open) {
			changeLmtOrder.setOrderState(OrderStatus.Canceled);
			this.limitOrderMart.save(changeLmtOrder);
		} 
		return "The order status is " + changeLmtOrder.getOrderState();
	}*/
	
	
}
