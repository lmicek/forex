package com.echo.forex.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "trade")
public class Trade implements Serializable{
	private static final long serialVersionUID = 8062312846871472399L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private CurrencyPairs currencyPair;
	private double price;
	private int lotSize;
	private String tradeTime;
	private Transaction transactionType;
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trade(CurrencyPairs tradeCurrency, double price, int lotSize, Transaction transactionType) {
		super();
		this.currencyPair = tradeCurrency;
		this.price = price;
		this.lotSize = lotSize;
		this.transactionType = transactionType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CurrencyPairs getCurrency() {
		return currencyPair;
	}

	public void setCurrency(CurrencyPairs tradeCurrency) {
		this.currencyPair = tradeCurrency;
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

	public String getTime() {
		return tradeTime;
	}

	public void setTime(String time) {
		this.tradeTime = time;
	}

	public Transaction getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Transaction transactionType) {
		this.transactionType = transactionType;
	}
	
}
