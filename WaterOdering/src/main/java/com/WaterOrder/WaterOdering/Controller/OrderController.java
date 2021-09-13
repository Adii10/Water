package com.WaterOrder.WaterOdering.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WaterOrder.WaterOdering.entities.Order;
import com.WaterOrder.WaterOdering.services.OrderService;




@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

   
    @GetMapping("/orders")
    public List<Order> getOrders() {

        return this.orderService.getOrders();

    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable String orderId)
    {
    	return this.orderService.getOrder(Long.parseLong(orderId));
    }
    
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order)
    {
    	return this.orderService.addOrder(order);
    }
    
    @PutMapping("/orders")
    public ResponseEntity<String>  updateOrder(@RequestBody Order order) {
    	try {
    		this.orderService.updateOrder(order);
    		return ResponseEntity.status(HttpStatus.OK)
    				.body("Data updated sucessfully.");
    	}catch (Exception e) {
    		
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Not able to update order.");
    	}
    }
    	
    
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {
    	try {
    		int c=this.orderService.deleteOrder(Long.parseLong(orderId));
    		if(c==1)
    		{
    			throw new Exception();
    		}
    		return ResponseEntity.status(HttpStatus.OK)
    				.body("Order deleted sucessfully.");
    	}catch (Exception e) {
    		
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Order Doesn't exist.");
    	}
    	
    		
    	
    }
    
}
