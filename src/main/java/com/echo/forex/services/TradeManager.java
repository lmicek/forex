package com.echo.forex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.forex.entities.Trade;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.TradesRepo;

@Service
public class TradeManager {

	private TradesRepo tradeMart;
	
	@Autowired
	public TradeManager(TradesRepo tradeRef) {
		this.tradeMart = tradeRef;
	}
	
	public long makeTrade(Trade nwTrade) {
		this.tradeMart.save(nwTrade);
		return nwTrade.getId();
	}
	
	public List<Trade> getAllTradesByTransactionType(Transaction transactionType) {
		return this.tradeMart.findByTransactionType(transactionType);
	}
	
	
}
