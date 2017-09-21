package com.echo.forex.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class LimitOrder implements Serializable{
	private static final long serialVersionUID = 8062312846871472399L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private CurrencyPairs currency;
	private double price;
	private int lotSize;
	private Transaction transactionType;
	private boolean isCompleted;
	
	
	public LimitOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LimitOrder(CurrencyPairs currency, double price, int lotSize, Transaction transactionType,
			boolean isCompleted) {
		super();
		this.currency = currency;
		this.price = price;
		this.lotSize = lotSize;
		this.transactionType = transactionType;
		this.isCompleted = isCompleted;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CurrencyPairs getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyPairs currency) {
		this.currency = currency;
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
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	

}
