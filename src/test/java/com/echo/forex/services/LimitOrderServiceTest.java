package com.echo.forex.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.LimitOrder;
import com.echo.forex.entities.OrderStatus;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.LimitOrderRepo;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class LimitOrderServiceTest {

	@Autowired
	private LimitOrderRepo limitOrderRepo;
	
	@Autowired
	private LimitOrderService limitOrderService;
	
	@Before
	public void initDatabase() {
		LimitOrder nwlmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.2000,1000,Transaction.BUY,OrderStatus.Open);
		limitOrderRepo.save(nwlmOrder);
	}
	@Test
	public void addNewLimitOrderTest() {
		LimitOrder nwerlmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.2000,1000,Transaction.BUY,OrderStatus.Open);
		long id = limitOrderService.addNewLimitOrder(nwerlmOrder);
		assertNotNull(id);
	}
	

}

