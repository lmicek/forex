package com.echo.forex.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Trade implements Serializable{
	private static final long serialVersionUID = 8062312846871472399L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private CurrencyPairs currency;
	private double price;
	private int lotSize;
	private LocalDateTime time;
	private Transaction transactionType;
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trade(CurrencyPairs currency, double price, int lotSize, LocalDateTime time, Transaction transactionType) {
		super();
		this.currency = currency;
		this.price = price;
		this.lotSize = lotSize;
		this.time = time;
		this.transactionType = transactionType;
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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Transaction getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Transaction transactionType) {
		this.transactionType = transactionType;
	}
	
}
