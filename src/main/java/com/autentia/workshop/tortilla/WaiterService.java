package com.autentia.workshop.tortilla;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class WaiterService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Connection conn;
	private final Channel channel;
	private final String exchange;
	
	public WaiterService(final String hostName, final int portNumber, final String exchange){
		try {
			this.exchange = exchange;
			final ConnectionFactory factory = new ConnectionFactory();
			factory.setUri("amqp://guest:guest@"+hostName+":"+portNumber+"/default");
			
			this.conn = factory.newConnection();
			this.channel = conn.createChannel();
		}catch(IOException | TimeoutException | KeyManagementException | NoSuchAlgorithmException | URISyntaxException e){
			throw new RuntimeException(e);
		}
	}
	
	public void serveTortilla(final Tortilla tortilla) {
		try {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
			
			channel.basicPublish(exchange, "", null, SerializationUtils.serialize(tortilla));
		}catch(IOException e){
			log.error("Error publishing on exchange: '"+exchange+"'", e);
			throw new RuntimeException(e);
		}
		
	}
}
