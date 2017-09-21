package com.echo.forex.services;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.Trade;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.TradesRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class TradeManagerTest {

	@Autowired
	private TradesRepo tradeRepo;
	
	@Before
	public void initDatabase() {
		Trade nwBuyTrade = new Trade(CurrencyPairs.USDCAD,1.3031,400,Transaction.BUY);
		Trade nwSellTrade = new Trade(CurrencyPairs.USDCAD,1.3031,400,Transaction.SELL);
		tradeRepo.save(nwBuyTrade);
		tradeRepo.save(nwSellTrade);
	}
	@Test
	public void buyTradeTest() {
		List<Trade> allBuyTrades = tradeRepo.findByTransactionType(Transaction.BUY);
		Trade rtnTrade = allBuyTrades.get(0);
		assertThat("Trade should be a buy tranction",Transaction.BUY,equalTo(rtnTrade.getTransactionType()));
		assertThat("Trade should have a currency pair of USDCAD",CurrencyPairs.USDCAD,equalTo(rtnTrade.getCurrency()));
		assertThat("Trade should have a lot size of 400",400,equalTo(rtnTrade.getLotSize()));
	}
	@Test
	public void sellTradeTest() {
		List<Trade> allSellTrades = tradeRepo.findByTransactionType(Transaction.SELL);
		Trade rtnTrade = allSellTrades.get(0);
		assertThat("Trade should be a sell tranction",Transaction.SELL,equalTo(rtnTrade.getTransactionType()));
		assertThat("Trade should have a currency pair of USDCAD",CurrencyPairs.USDCAD,equalTo(rtnTrade.getCurrency()));
		assertThat("Trade should have a lot size of 400",400,equalTo(rtnTrade.getLotSize()));
	}

}
