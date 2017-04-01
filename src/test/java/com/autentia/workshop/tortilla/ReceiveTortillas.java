package com.autentia.workshop.tortilla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiveTortillas {
	
	private static final String HOST_NAME = "5.56.60.112";
	private static int PORT_NUMBER = 5672;
	private static final String QUEUE = "workshop_tortillas_queue";
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	

	
	public static void main(String[] args) throws Exception {
		
		
		final ReceiveTortillas receiveTortillas = new ReceiveTortillas();
		receiveTortillas.received_tortillas();
		
	}
	
	
	public void received_tortillas() throws Exception {
		
		final List<Tortilla> tortillasConCebolla = new ArrayList<Tortilla>();
		final List<Tortilla> tortillasSinCebolla = new ArrayList<Tortilla>();
	
		
		final ExecutorService executorAdder = Executors.newFixedThreadPool(1);
		executorAdder.submit(new Callable<Boolean>(){

			@Override
			public Boolean call() throws Exception {
				while(true) {
					log.info("------------ Tortillas Con Cebolla served: "+tortillasConCebolla.size());
					log.info("------------ Tortillas Sin Cebolla served: "+tortillasSinCebolla.size());
					log.info("------------ ");
					Thread.sleep(2000);
				}
			}
		});
		
		
		final ConnectionFactory factory = new ConnectionFactory();
		factory.setUri("amqp://guest:guest@"+HOST_NAME+":"+PORT_NUMBER+"/default");
		
		final Connection conn = factory.newConnection();
		final Channel channel = conn.createChannel();
		
		channel.basicConsume(QUEUE, true, new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {					
				final Tortilla tortilla = SerializationUtils.deserialize(body);
				
				if(tortilla instanceof TortillaConCebolla){
					tortillasConCebolla.add(tortilla);
				}else if(tortilla instanceof TortillaSinCebolla){
					tortillasSinCebolla.add(tortilla);
				}
				
			}
			
		});
		
	}
}
