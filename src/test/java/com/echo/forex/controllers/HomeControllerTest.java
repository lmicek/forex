package com.echo.forex.controllers;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

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
import com.echo.forex.entities.Trade;
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.TradesRepo;

import io.restassured.response.Response;

import static org.hamcrest.core.IsEqual.equalTo;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class HomeControllerTest {

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
	public void indetrxTest() {
		Response rsp = 
				given().get("/")
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().response();
	}
	
	@Test
	public void tradesTest() {
		Response rsp = 
				given().get("/trades")
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().response();
	}
	
	@Test
	public void buyTradeTest() {
		Trade nwTrade = new Trade(CurrencyPairs.USDCAD,1.2000,1000,Transaction.BUY);
		long rtnTradeId = 
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(nwTrade).post("/buytrade")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Long.class);
		assertNotNull(rtnTradeId);
	}
	
	@Test
	public void sellTradeTest() {
		Trade nwTrade = new Trade(CurrencyPairs.USDCAD,1.2000,1000,Transaction.SELL);
		long rtnTradeId = 
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(nwTrade).post("/selltrade")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Long.class);
		assertNotNull(rtnTradeId);
	}
	
	@Test
	public void addTradeTest(){
		Trade nwTrade = new Trade(CurrencyPairs.USDCAD,1.2000,1000,Transaction.SELL);
		Trade rtnTrade = 
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(nwTrade).post("/addtrades")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Trade.class);
		assertEquals(nwTrade.getLotSize(),rtnTrade.getLotSize());
	}

}
