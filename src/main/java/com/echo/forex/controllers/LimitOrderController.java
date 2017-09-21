package com.echo.forex.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.echo.forex.entities.LimitOrder;
import com.echo.forex.services.LimitOrderService;
import com.fasterxml.jackson.core.sym.Name;

@RestController(value="limitOrderController")
public class LimitOrderController {
	
	private final LimitOrderService lmOrdService;

	public LimitOrderController(LimitOrderService limitOrdService) {
		this.lmOrdService = limitOrdService;
	}
	
	@RequestMapping(path="/limitorders",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getAllLimitOrders() {
		return new ResponseEntity(lmOrdService.getAllLimitOrders(),HttpStatus.OK);
	}
	@RequestMapping(path="/placelimitorder",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object createLimitOrder(@RequestBody LimitOrder nwLmOrder) {
		this.lmOrdService.addNewLimitOrder(nwLmOrder);
		return new ResponseEntity(nwLmOrder.getId(),HttpStatus.CREATED);
	}
	@RequestMapping(path="/completedlimitorders",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getCompletedLimitOrders() {
		return new ResponseEntity(lmOrdService.getAllCompletedLimitOrders(), HttpStatus.OK);
	}
	@RequestMapping(path="/incompletelimitorders",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getInCompletedLimitOrders() {
		return new ResponseEntity(lmOrdService.getAllInCompleteLimitOrders(), HttpStatus.OK);
	}
	@RequestMapping(path="/limitorder/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getLimitOrderById(@PathVariable long id) {
		return new ResponseEntity(lmOrdService.getLimitOrderById(id),HttpStatus.OK);
	}
	@RequestMapping(path="/cancellimitorder/{id}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object cancelLimitOrderById(@PathVariable long id) {
		return new ResponseEntity(lmOrdService.cancelLimitOrderById(id),HttpStatus.OK);
	}

}
