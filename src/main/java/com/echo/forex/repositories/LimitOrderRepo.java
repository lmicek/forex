package com.echo.forex.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.LimitOrder;
import com.echo.forex.entities.Transaction;

public interface LimitOrderRepo extends CrudRepository<LimitOrder, Long> {
	List<LimitOrder> findByTransactionType(Transaction transactionType);
	List<LimitOrder> findByCurrencyPair(CurrencyPairs currency);
	List<LimitOrder> findById(long id);
	List<LimitOrder> findByIsCompleted(boolean isCompleted);
	
}
