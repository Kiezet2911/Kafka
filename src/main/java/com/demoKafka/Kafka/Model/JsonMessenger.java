package com.demoKafka.Kafka.Model;

import java.util.Date;

public class JsonMessenger{
	private String id;
	private String mess;
	private Date timesend;

	public JsonMessenger(String id, String mess, Date timesend) {
		super();
		this.id = id;
		this.mess = mess;
		this.timesend = timesend;
	}

	public JsonMessenger() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public Date getTimesend() {
		return timesend;
	}

	public void setTimesend(Date timesend) {
		this.timesend = timesend;
	}

}
