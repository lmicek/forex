package com.echo.forex.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="limitorder")
public class LimitOrder implements Serializable{
	private static final long serialVersionUID = 8062312846871472399L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private CurrencyPairs limitOrderCurrPair;
	private double price;
	private int lotSize;
	private Transaction transactionType;
	private OrderStatus orderState;
	
	
	public LimitOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LimitOrder(CurrencyPairs currencypair, double price, int lotSize, Transaction transactionType,
			OrderStatus orderState) {
		super();
		this.limitOrderCurrPair = currencypair;
		this.price = price;
		this.lotSize = lotSize;
		this.transactionType = transactionType;
		this.orderState = orderState;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CurrencyPairs getCurrency() {
		return limitOrderCurrPair;
	}
	public void setCurrency(CurrencyPairs loCurrencyP) {
		this.limitOrderCurrPair = loCurrencyP;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getLotSize() {
		return lotSize;
	}
	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}
	public Transaction getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Transaction transactionType) {
		this.transactionType = transactionType;
	}

	public OrderStatus getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderStatus orderState) {
		this.orderState = orderState;
	}

}
