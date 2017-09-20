package com.echo.forex.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.echo.forex.entities.Trade;
import com.echo.forex.entities.Transaction;

public interface TradesRepo extends CrudRepository<Trade, Long> {
	List<Trade> findByTransactionType(Transaction transactionType);
}
