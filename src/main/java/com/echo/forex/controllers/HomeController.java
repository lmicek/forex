package com.echo.forex.controllers;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.echo.forex.entities.CurrencyPairs;
import com.echo.forex.entities.Trade;
import com.echo.forex.entities.Transaction;
import com.echo.forex.services.TradeManager;

@RestController
public class HomeController {

	private final TradeManager tradeMgr;

	public HomeController(TradeManager tdManger) {
		this.tradeMgr = tdManger;
	}
	
	@RequestMapping(path="/",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object index() {
		return new ResponseEntity(Arrays.asList(CurrencyPairs.values()),HttpStatus.OK);
	}
	@RequestMapping(path="/trades",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getAllTrades() {
		return new ResponseEntity(tradeMgr.getAllTrades(),HttpStatus.OK);
	}
	@RequestMapping(path="/addtrades",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object addTrade(@RequestBody Trade nwTrade) {
		this.tradeMgr.addNewTrade(nwTrade);
		return new ResponseEntity<Trade>(nwTrade,HttpStatus.CREATED);
	}
	@RequestMapping(path="/buytrade",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object buyTrade(@RequestBody Trade nwTrade) {
		nwTrade.setTransactionType(Transaction.BUY);
		this.tradeMgr.addNewTrade(nwTrade);
		return new ResponseEntity(nwTrade.getId(),HttpStatus.CREATED);
	}
	@RequestMapping(path="/selltrade",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object sellTrade(@RequestBody Trade nwTrade) {
		nwTrade.setTransactionType(Transaction.SELL);
		this.tradeMgr.addNewTrade(nwTrade);
		return new ResponseEntity(nwTrade.getId(),HttpStatus.CREATED);
	}
	
	
	
}
