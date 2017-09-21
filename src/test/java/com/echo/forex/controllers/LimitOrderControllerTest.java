package com.echo.forex.controllers;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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
import com.echo.forex.entities.Transaction;
import com.echo.forex.repositories.LimitOrderRepo;

import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class LimitOrderControllerTest {

	@Autowired
	private LimitOrderRepo lmOrderRepo;
	
	@Before
	public void initDatabase() {
		LimitOrder nwIncompleteLmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.3031,400,Transaction.BUY,false);
		LimitOrder nwCompleteLmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.3031,400,Transaction.SELL,true);
		lmOrderRepo.save(nwIncompleteLmOrder);
		lmOrderRepo.save(nwCompleteLmOrder);
	}
	
	@Test
	public void getAllLimitOrders() {
		Response rsp = 
				given().get("/limitorders")
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().response();
		assertNotNull(rsp);
	}
	
	@Test
	public void placeLimitOrderTest() {
		LimitOrder nwLmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.2000,1000,Transaction.BUY,false);
		long rtnLmOrderId = 
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(nwLmOrder).post("/placelimitorder")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Long.class);
		assertNotNull(rtnLmOrderId);
	}
	
	@Test
	public void getAllCompletedLimitOrdersTest(){
		Response rsp = 
				given().get("/completedlimitorders")
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().response();
		assertNotNull(rsp);
	}
	
	@Test
	public void getAllInCompletedLimitOrdersTest(){
		Response rsp = 
				given().get("/incompletelimitorders")
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().response();
		assertNotNull(rsp);
	}
	
	@Test
	public void getLimitOrderByIdTest(){
		LimitOrder nwLmOrder = new LimitOrder(CurrencyPairs.USDCAD,1.2000,1000,Transaction.BUY,false);
		long rtnLmOrderId = 
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(nwLmOrder).post("/placelimitorder")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Long.class);
		LimitOrder lmOrder = 
				given().get("/limitorder/{id}", rtnLmOrderId)
				.then().statusCode(HttpStatus.OK.value())
				.and().extract().as(LimitOrder.class);
		assertEquals(CurrencyPairs.USDCAD,lmOrder.getCurrency());
		assertThat("The Currency pair is USDCAD ",CurrencyPairs.USDCAD,equalTo(lmOrder.getCurrency()));
	
	}
	
	

}
