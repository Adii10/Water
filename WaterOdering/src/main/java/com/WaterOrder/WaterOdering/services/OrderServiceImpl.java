package com.WaterOrder.WaterOdering.services;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.WaterOrder.WaterOdering.entities.Order;



@Service
public class OrderServiceImpl implements OrderService {

	List<Order> list;
    List<Timer> timer;
	
    public OrderServiceImpl() {

        list = new ArrayList<>();
        list.add(new Order(11,new Date(2021,9,13), new Time(16,31,15), 3));
        list.add(new Order(12,new Date(11,12,2021), new Time(11,12,15), 3));
        list.add(new Order(15,new Date(11,12,2021), new Time(11,12,15), 3));

    }
    
	
	
	
	@Override
	public List<Order> getOrders() {
		
		return list;
	}
	
	@Override
	public Order getOrder(long orderId)
	{
		Order o=null;
		
		for(Order order:list)
		{
			if(order.getId()==orderId)
			{
				o=order;
				break;
			}
		}
		return o;
	}
	
	@Override
	public Order addOrder(Order order) {
		
		list.add(order);
		
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY,17);
	    cal.set(Calendar.MINUTE,30);
	    cal.set(Calendar.SECOND,0);
	    cal.set(Calendar.MILLISECOND,0);

	    cal.setTime(order.getDate());
	    Date d = cal.getTime();
        System.out.println(d);
	  
		try {
			d = dateFormatter .parse(d.toString());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

	 
	    Timer obj = new Timer();

	  
	    obj.schedule(new MyTimeTask(), d);

	   
	

		//timer.add(obj);
		return order;
		
	}
	
	@Override
	public Order updateOrder(Order order) {
		final boolean flag=false;
		list.forEach(e-> {
			if (e.getId() == order.getId()) {
				
				e.setDate(order.getDate());
				e.setTime(order.getTime());
				e.setDuration(order.getDuration());
			}
		});
		return order;
	}
	
	@Override
	public int deleteOrder(long parseLong) {
	
		
			boolean flag=false;
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getId()==parseLong)
	
				{
					flag=true;
				}
			}
			if(flag==true)
			{	
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
			return 0;
			}
			else
			{
				return 1;
	

			}
			
			
	
		
		
		}
	
	

}
