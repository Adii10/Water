package com.WaterOrder.WaterOdering.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Order {

	private int id;
    private Date date;
    private Time time;
    private int duration;

    public Order(int id, Date date, Time time, int duration) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "orders [date=" + date + ", duration=" + duration + ", id=" + id + ", time=" + time + "]";
    }
	
}
