package com.WaterOrder.WaterOdering.services;

import java.util.List;

import com.WaterOrder.WaterOdering.entities.Order;



public interface OrderService {

   

	public List<Order> getOrders();
	
	public Order getOrder(long orderId);
	
	public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public int deleteOrder(long parseLong);

}
